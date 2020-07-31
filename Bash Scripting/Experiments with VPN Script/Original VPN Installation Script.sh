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
MIIErTCCA5WgAwIBAgIJAPp3HmtYGCIOMA0GCSqGSIb3DQEBCwUAMIGVMQswCQYD
VQQGEwJTRTELMAkGA1UECBMCQ0ExEjAQBgNVBAcTCVN0b2NraG9sbTETMBEGA1UE
ChMKUHJpdmF0ZVZQTjEWMBQGA1UEAxMNUHJpdmF0ZVZQTiBDQTETMBEGA1UEKRMK
UHJpdmF0ZVZQTjEjMCEGCSqGSIb3DQEJARYUc3VwcG9ydEBwcml2YXR2cG4uc2Uw
HhcNMTcwNTI0MjAxNTM3WhcNMjcwNTIyMjAxNTM3WjCBlTELMAkGA1UEBhMCU0Ux
CzAJBgNVBAgTAkNBMRIwEAYDVQQHEwlTdG9ja2hvbG0xEzARBgNVBAoTClByaXZh
dGVWUE4xFjAUBgNVBAMTDVByaXZhdGVWUE4gQ0ExEzARBgNVBCkTClByaXZhdGVW
UE4xIzAhBgkqhkiG9w0BCQEWFHN1cHBvcnRAcHJpdmF0dnBuLnNlMIIBIjANBgkq
hkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwjqTWbKk85WN8nd1TaBgBnBHceQWosp8
mMHr4xWMTLagWRcq2Modfy7RPnBo9kyn5j/ZZwL/21gLWJbxidurGyZZdEV9Wb5K
Ql3DUNxa19kwAbkkEchdES61e99MjmQlWq4vGPXAHjEuDxOZ906AXglCyAvQoXcY
W0mNm9yybWllVp1aBrCaZQrNYr7eoFvolqJXdQQ3FFsTBCYa5bHJcKQLBfsiqdJ/
BAxhNkQtcmWNSgLy16qoxQpCsxNCxAcYnasuL4rwOP+RazBkJTPXA/2neCJC5rt+
sXR9CSfiXdJGwMpYso5m31ZEd7JL2+is0FeAZ6ETrKMnEZMsTpTkdwIDAQABo4H9
MIH6MB0GA1UdDgQWBBRCkBlC94zCY6VNncMnK36JxT7bazCBygYDVR0jBIHCMIG/
gBRCkBlC94zCY6VNncMnK36JxT7ba6GBm6SBmDCBlTELMAkGA1UEBhMCU0UxCzAJ
BgNVBAgTAkNBMRIwEAYDVQQHEwlTdG9ja2hvbG0xEzARBgNVBAoTClByaXZhdGVW
UE4xFjAUBgNVBAMTDVByaXZhdGVWUE4gQ0ExEzARBgNVBCkTClByaXZhdGVWUE4x
IzAhBgkqhkiG9w0BCQEWFHN1cHBvcnRAcHJpdmF0dnBuLnNlggkA+ncea1gYIg4w
DAYDVR0TBAUwAwEB/zANBgkqhkiG9w0BAQsFAAOCAQEAayugvExKDHar7t1zyYn9
9Vt1NMf46J8x4Dt9TNjBml5mR9nKvWmreMUuuOhLaO8Da466KGdXeDFNLcBYZd/J
2iTawE6/3fmrML9H2sa+k/+E4uU5nQ84ZGOwCinCkMalVjM8EZ0/H2RZvLAVUnvP
uUz2JfJhmiRkbeE75fVuqpAm9qdE+/7lg3oICYzxa6BJPxT+Imdjy3Q/FWdsXqX6
aallhohPAZlMZgZL4eXECnV8rAfzyjOJggkMDZQt3Flc0Y4iDMfzrEhSOWMkNFBF
wjK0F/dnhsX+fPX6GGRpUZgZcCt/hWvypqc05/SnrdKM/vV/jV/yZe0NVzY7S8Ur
5g==
-----END CERTIFICATE-----
</ca>
<tls-auth>
-----BEGIN OpenVPN Static key V1-----
f035a3acaeffb5aedb5bc920bca26ca7
ac701da88249008e03563eba6af6d262
5ac8ba1e5e0921f76be004c24ae4fd43
e42caf0f84269ad44d8d4c14ba45b138
6f251c7330d8cc56afd16d5168356456
51ef7e87a723ac78ae0d49da5b2f2d78
ceafcff7a6367d0712628a6547e5fc8f
ef93c87f7bcd6107c7b1ae68396e944a
adae50111d01a5d0c67223d667bdbf1b
f434bdef03644ecc5386e102724eef38
72f66547eb66dc0fea8286069cb082a4
1c89083b28fe9f4cec25d48017f26c4f
d85b25ddf2ae5448dd2bccf3eef2aacf
42ef1e88c3248c689423d0b05a641e9e
79dd6b9b5c40f0cc21ffdc891b9eee95
1477b537261cb56a958a4f490d961ecb
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
