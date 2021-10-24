# For Sysadmins

## Take Note

You must know all the commands in 'Useful Commands' first

### -dry-run

For many utilities, you can test your command first

## Networking

For Debian family configurations, the basic network configuration files could be found under /etc/network/, while for Fedora and SUSE family systems one needed to inspect /etc/sysconfig/network.

In the /etc/hosts file, you can associate names with IP addresses. The file is used before the DNS server is consulted. This is most useful for specifying nodes on your local network. 

Change your DNS servers via /etc/resolv.conf

```bash
$ cat /etc/hosts
$ cat /etc/resolv.conf
```

### FTP

FTP - client-server model, out-dated and insecure
CLI FTP clients - `ftp; sftp, ncftp; yafc`
Graphical - FileZilla
`rsync; https` are favoured
`sftp` uses the SSH protocol, so is very secure, but does not work with anonymous FTP

### SSH

Cryptographic protocol

`scp` - Secure Copy
`scp local_file user@remotesystem:/destination_path/`

### Reserved and Special IP addresses

https://www.tutorialspoint.com/ipv4/ipv4_reserved_addresses.htm
https://www.howtogeek.com/225487/what-is-the-difference-between-127.0.0.1-and-0.0.0.0/
https://www.tech-faq.com/127-0-0-1.html

#### Loopback

When you call localhost, you are calling a server on your own computer.
*.localhost* is a top-level domain name too but reserved for documentation and testing. When you try to access it, it triggers a loopback. The request to access http://localhost will stay in your machine
127.0.0.1 is the usual IPv4 IP address, but the range of address reserved for loopback goes until 127.255.255.255
::1 is the IPv6
https://www.ionos.com/digitalguide/server/know-how/localhost/
https://serverfault.com/questions/402938/what-is-the-rest-of-the-127-0-0-0-8-address-space-used-for

### nmtui; nmcli

### route

### traceroute

### dig; nslookup; host

`dig` > `nslookup` > `host`
`dig` is the most powerful tool; displays domain name information
`nslookup` displays name servers
`host` displays hostnames

### ethtool

Queries network interfaces, can set parameters such as the speed

### netstat

Displays active connections and routing tables
`netstat -r`

### nmap

Scans open ports
`# nmap -sP x.x.x.x`

### tcpdump

Dumps network traffic

### iptraf

Monitors network traffic

### mtr

`ping` + `traceroute` + continual updates

### Lynx; ELinks; w3m

Text-based browsers

## System

### ioctl

### loginctl

`loginctl show-session $(loginctl | grep $(whoami) | awk '{print $1}') -p`

### systemctl

`sudo systemctl stop gdm` - to stop display manager

### telinit (for System V, so outdated)

### udev

https://opensource.com/article/18/11/udev

### visudo

https://www.digitalocean.com/community/tutorials/how-to-edit-the-sudoers-file

`man sudoers`

### at

Schedule future processes

```bash
$ at now + 2 days #when
at> cat file1.txt #what
at> <EOT> # Ctrl + D
```

### cron

Time-based scheduling utility program to launch routine background jobs at specific times and/or days

`crontab -e ` will open the crontab editor to edit existing jobs or to create new jobs. See the configuration file at /etc/crontab for details of job definitions. The config file also contains the various shell commands that need to be run at scheduled times. There are both system-wide crontab files and individual user-based ones. * symbolises 'for all values of the field'.

### sleep

### systemctl start nfs

#### Server

/etc/exports contains directories and permissions that a host is willing to share over NFS. A sample entry:

/projects *.example.com(rw)

After modifying /etc/exports/, type`exportfs -av` to notify Linux about the directories you are allowing to be remotely mounted using NFS. You can also restart NFS with `sudo systemctl restart nfs`, but this is heavier, as it halts NFS for a short while before starting it up again. 

To make sure the NFS service starts whenever the system is booted, issue `sudo systemctl enable nfs`.

#### Client

On the client machine, if it is desired to have the remote filesystem mounted automatically upon system boot, /etc/fstab is modified to accomplish this.

servername:/projects /mnt/nfs/projects nfs defaults 0 0

You can also mount the remote filesystem without a reboot or as a one-time mount by directly using `mount`:

`$ sudo mount servername:/projects /mnt/nfs/projects`

Furthermore, you may want to use the nofail option in fstab in case the NFS server is not live at boot.

## File

### strings

Print the sequence of printable characters in a file (mainly useful only for non-text or binary files)

### patch

When distributing modifications to source code and config files

Produce patch files by running `$ diff -Nur originalfile newfile > patchfile`

To apply a patch, do either `$ patch -p1 < patchfile` or  `$ patch originalfile patchfile.`The first usage is often used to apply changes to an entire directory tree, rather than just one file, as in the second usage.

### rsync

Locations are designated in the target:path form, where target can be in the form of someone@host. The someone@ part is optional and used if the remote user is different from the local user.

`$ rsync -r project-X archive-machine:archives/project-X`nu