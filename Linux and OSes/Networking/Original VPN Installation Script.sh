#!/bin/bash
VERSION="0.3"

#SETTINGS
OPENVPN_BIN="/usr/sbin/openvpn"
INSTALL_PATH="/etc/openvpn"
PV_CONF="privatvpn.conf"
PV_LOGIN="privatvpn.login"
PV_SCR="/usr/bin/privatvpn"
SERVER_LIST_URL="https://privatevpn.com/serverlist/"
SERVER_NAME="vpn-se8.privatevpn.com"

select_server_from_list () {
  local SERVER_LIST_FILE="$1"
  printf " * Select a server from this list by entering it's number:\n"
  if which column 2>&1 > /dev/null; then
    cat -n "$SERVER_LIST_FILE" | column
  else
    cat -n "$SERVER_LIST_FILE"
  fi
  while true; do
    printf " - [server number]: "
    read -e SERVER_NUMBER
    case "$SERVER_NUMBER" in
      [1-9]) ;&
      [1-9][0-9]*) SERVER_NAME="$(sed -n "${SERVER_NUMBER}p" "$SERVER_LIST_FILE")"; test -n "$SERVER_NAME" && break ;&
      *)      printf "Invalid selection, please enter a number from the list.\n";
    esac
  done
  printf " - Using the server: %s\n" "$SERVER_NAME"
}

###############################################################################
#                         FETCHING USERINPUT DATA                             #
###############################################################################

printf "PrivateVPN Linux OpenVPN Installer v%s\n" "$VERSION"
printf " * Checking for OpenVPN - "
if [ -x "$OPENVPN_BIN" ]; then
  printf "OK\n"
else
  printf "Not Found\n - Unable to find OpenVPN, enter PATH where OpenVPN bin is installed.\n [PATH]: "
  read -e OPENVPN_BIN
fi

if [ ! -x "$OPENVPN_BIN" ]; then
  printf " - ERROR! Unable to find OpenVPN, please install it before running this script.\n"
  exit
fi 

# Installing the conf may require root (it does for the default location)
# and installing the $PV_SCR always requires root.
if [ "$(id -u)" -ne 0 ]; then
  printf " - ERROR! The install needs to be run as root/sudo.\n"
  exit
fi

printf " * Enter login details for PrivateVPN\n - [username]: "
read -e USERNAME
printf " - [password]: "
read -e PASSWORD


printf " * Installing conf to default location (/etc/openvpn), write c to edit installpath.\n"

while true; do
   printf " - Continue [yes/no/c] "
   read -e SELECT
   case "$SELECT" in
      'yes') break ;;
      'no') exit ;;
      'c') printf " - [PATH]:" ; read -e INSTALL_PATH ; break ;;
      '*') printf " - Unknown input\n" ;;
   esac 
done

# Create install dir if needed
if [ ! -d "$INSTALL_PATH" ]; then
  mkdir -p "$INSTALL_PATH"
fi

# Fetch the list of available servers
FETCH=""
if which wget 2>&1 > /dev/null; then
  FETCH="wget -qO -"
elif which curl 2>&1 > /dev/null; then
  FETCH="curl"
fi
if [ "$FETCH" != "" ]; then
  printf "Fetching the server list from %s\n" "$SERVER_LIST_URL"
  SERVER_LIST_FILE="$(mktemp)"
  $FETCH "$SERVER_LIST_URL" | sed -n '/^<td>$/,/^<\/td>$/ s/^\(.\+\.privatevpn\.com\)$/\1/p' > "$SERVER_LIST_FILE"
  if [ -s "$SERVER_LIST_FILE" ]; then
    select_server_from_list "$SERVER_LIST_FILE"
  fi
  rm "$SERVER_LIST_FILE"
else
  printf " - No wget/curl available to fetch a fresh server list, defaulting to the server: %s\n" "$SERVER_NAME"
fi

###############################################################################
#                         GENERATING OPENVPN FILE                             #
###############################################################################

# Restrict the access to the conf file
touch "$INSTALL_PATH/$PV_CONF"
chmod 0600 "$INSTALL_PATH/$PV_CONF"
cat << EOF > "$INSTALL_PATH/$PV_CONF"
remote $SERVER_NAME 1194 udp
nobind
dev tun

# Options
tun-ipv6
remote-cert-tls server
client
comp-lzo
persist-key
persist-tun
verb 3

# Crypto
cipher AES-128-CBC
auth SHA256
auth-user-pass $INSTALL_PATH/$PV_LOGIN
script-security 2
up /etc/openvpn/update-resolv-conf
down /etc/openvpn/update-resolv-conf

# Cert
<ca>
-----BEGIN CERTIFICATE-----

-----END CERTIFICATE-----
</ca>
<tls-auth>
-----BEGIN OpenVPN Static key V1-----

-----END OpenVPN Static key V1-----
</tls-auth>
key-direction 1
EOF

# Restrict the access to the auth-user-pass file
touch "$INSTALL_PATH/$PV_LOGIN"
chmod 0600 "$INSTALL_PATH/$PV_LOGIN"
cat << EOF > "$INSTALL_PATH/$PV_LOGIN"
$USERNAME
$PASSWORD
EOF

# Create a priv
cat << EOF > "$PV_SCR"
#!/bin/sh
exec $OPENVPN_BIN $INSTALL_PATH/$PV_CONF
EOF
chmod +x "$PV_SCR"

printf " * Installation Complete, run \"sudo %s\" to connect to PrivatVPN service.\n" "$(basename "$PV_SCR")"
