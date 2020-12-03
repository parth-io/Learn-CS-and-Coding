See the *Kali Linux Revealed* book, especially the chapter on installing Kali Linux

## Installing Kali Linux on VMWare

Download VMWare Workstation Player for personal download

Then follow instructions in this guide: 
https://www.kali.org/docs/virtualization/install-vmware-workstation-player-kali-guest-vm/

Then install VMWare tools:
https://www.kali.org/docs/virtualization/install-vmware-tools-kali-guest/
http://lewiscomputerhowto.blogspot.com/2013/06/how-to-install-vmware-tools-in-kali_20.html

For more shit:
https://www.nakivo.com/blog/install-kali-linux-vmware/

## Installing Additional Software

In order to be able to install additional software, APT needs to be configured and told where to find Debian packages. In Kali, this step is mostly non-interactive as we force the mirror to be http.kali.org. You just have to confirm whether you want to use this mirror (Figure 4.15, “Use a Network Mirror?” [page 81]). If you don’t use it, you won’t be able to install supplementary packages with apt unless you configure a package repository later. If you want to use a local mirror instead of http.kali.org, you can pass its name on the kernel command line (at boot-time) with a syntax like this: mirror/http/hostname=my.own.mirror.

Finally, the program proposes to use an HTTP proxy as shown in Figure 4.16, “Use an HTTP Proxy” [page 82]. An HTTP proxy is a server that forwards HTTP requests for network users. It sometimes helps to speed up downloads by keeping a copy of files that have been transferred through it (we then speak of a caching proxy). In some cases, it is the only means of accessing an external web server; in such cases the installer will only be able to download the Debian packages if you properly fill in this field during installation. If you do not provide a proxy address, the installer will attempt to connect directly to the Internet.

## Partitions

LVM and LUKS - to manage storage dynamically and to encrypt partitions

## Preseeded Installations

For preseeded installations, see Chapter 4.3 Unattended Installations of the Kali Linux book

## Booting Kali Linux

Live mode boots to RAM, but may auto-mount disks. Forensics mode does not auto-mount drives.

How can we verify that forensics mode is working?

Use the mount command to verify that no disks are mounted. You can also md5 the system’s swap and disk devices, reboot into forensic mode and md5 again. The md5 hashes should match if forensics mode succeeded. Try this in a system you don’t care about “tainting”!

Use md5sum ()
Or use http://getmd5checker.com/

#### To Read Again:

https://support.authorize.net/s/article/What-is-the-MD5-Hash-Security-feature-and-how-does-it-work
https://unix.stackexchange.com/questions/232974/hdd-image-file-checksum-does-not-match-with-device-checksum