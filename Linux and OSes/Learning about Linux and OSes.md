[TOC]

## Kernel

Kernel - runs in ring 0 or kernel space (https://kali.training/topic/what-is-linux-and-what-is-it-doing/)\
https://en.wikipedia.org/wiki/Protection_ring\
https://en.wikipedia.org/wiki/Booting\
https://stackoverflow.com/questions/6710040/cpu-privilege-rings-why-rings-1-and-2-arent-used\
https://stackoverflow.com/questions/18717016/what-are-ring-0-and-ring-3-in-the-context-of-operating-systems\
https://unix.stackexchange.com/questions/87625/what-is-difference-between-user-space-and-kernel-space\
https://en.wikipedia.org/wiki/User_space\
UEFI vs BIOS - http://www.extremetech.com/computing/96985-demystifying-uefi-the-long-overdue-bios-replacement

### Hardware
Data about hardware - stored in /proc/ and /sys/\
Applications can access devices via files in /dev/ - /dev/input/mouse0 for mice, /dev/snd/* for soundcards\
Block and character device files - run ls -l /path_to_device\
ioctl command

### File systems
Kernel translates between disk storage locations and the filesystem hierarchy\
Linux makes a single disk the root, other disks are simply mounted\
File system formats - ext4, NTFS, etc.
### Processes

Process =/= program or command

Types - threads, kernel thread, daemons, interactive and batch processes

Scheduler in kernel allocates processes to CPU

Running, sleep

PID, PPID, TID, UID (RUID and EUID), GID (RGID and EGID)

Priority of processes - nice values range from -20 to +19 (lowest), you can aslo assign real-time priority

Multitasking and multiple processor cores

#### Load average

Average of load number

Considers running, queued, sleeping processes (including uninterruptible sleepers)

### Permissions

Permissions for users can be set. See Scripting Notes.

### Boot Process

Power On --> BIOS --> MBR --> Boot loader (GRUB) --> Kernel --> Initial RAM --> /sbin/init --> getty --> X window/Wayland

## Command Line

### tty and the GUI
If you cannot access the GUI, use tty.\
https://ostechnix.com/how-to-switch-between-ttys-without-using-function-keys-in-linux/\
https://askubuntu.com/questions/66195/what-is-a-tty-and-how-do-i-access-a-tty

https://unix.stackexchange.com/questions/4126/what-is-the-exact-difference-between-a-terminal-a-shell-a-tty-and-a-con

Ctrl + Alt + Fn1-7

#### Booting into tty or into GUI
https://askubuntu.com/questions/825094/how-do-i-boot-directly-to-tty1-in-ubuntu\
startx has not been maintained for long - https://askubuntu.com/questions/436546/ubuntu-12-04-boots-to-tty1, https://askubuntu.com/questions/518454/what-does-startx-command-do

`sudo systemctl start gdm`

### Basics
Bash, zh, sh, ksh\
$ and #\
Bash commands are either shell builtins like `cd` and `pwd` or found at locations designated in the PATH environmental variable\
Environment variables store the global settings for the shell or other programs. They are contextual - each process has its own set of environment variables - but inheritable - shells, like login shells, can pass down variable to other programs they execute.\
Go to /etc/profile to change system settings or user-specific in ~/.profile but variables that are not specific to command line interpreters are better put in /etc/environment, since those variables will be injected into all user sessions thanks to a Pluggable Authentication Module (PAM) – even when no shell is executed.

## Linux File System

### Filesystem Hierarchy Standard 

### /proc

Contain virtual files (files that exist only in memory) that mimic kernel structures and configuration information permit viewing constantly changing kernel data and runtime system information, e.g. system memory, devices mounted, hardware configuration, etc.

### /dev

The /dev directory contains device nodes, a type of pseudo-file used by most hardware and software devices, except for network devices. This directory is:

- - - Empty on the disk partition when it is not mounted

- - - Contains entries which are created by the udev system, which creates and manages device nodes on Linux, creating them dynamically when devices are found. The /dev directory contains items such as:

1. 1. 1. 1. 1. /dev/sda1
            2. /dev/random (a source of random numbers)

### /var

The /var directory contains files that are expected to change in size and content as the system is running (var stands for variable), such as system log files in /var/log, print queues in /var/spool/, network services directories in /var/ftp and /var/www (the HTTP web service), and packages and database files in /var/lib.

The /var directory may be put on its own filesystem so that any exploding file sizes do not fatally affect the system.

### /etc

Contains system config files

No binary programs are here, but executable scripts can be here

### /boot

Files needed to boot the system

1. vmlinux - the compressed Linux kernel
2. initramfs - the initial ram filesystem
3. config - kernel config files
4. System.map - kernel symbol table
5. GRUB files

### /lib; /lib64

Contains libraries shared by applications in /bin and /sbin

Most libraries are dynamically loaded libraries or Shared Objects (SO)

Kernel modules (device drivers) are in /lib/modules

Usually these libraries are symbolic links to /usr/lib and /usr/lib64 - to verify, run `ls -F/-lF`

### /media; /run; /mnt

Modern distros place these removable media's mount point at /run instead of /media

/mnt is now ususally used for loopback (files pretending to be partitions) filesystems, or for network filesystems

### /opt; /sys; /srv; /tmp; /usr

| **Directory Name ** | **Usage**                                                    |
| ------------------- | ------------------------------------------------------------ |
| **/opt**            | Optional application software packages                       |
| **/sys**            | Virtual pseudo-filesystem giving information about the system and the hardware Can be used to alter system parameters and for debugging purposes |
| **/srv**            | Site-specific data served up by the system  Seldom used      |
| **/tmp**            | Temporary files; on some distributions erased across a reboot and/or may actually be a ramdisk in memory |
| **/usr**            | Multi-user applications, utilities and data                  |

### /usr

For multi-user applications, data and utilities; contains theoretically non-essential programs and scripts (not be needed to initially boot  the system); has at least the following sub-directories: 

| **Directory Name ** | **Usage**                                                    |
| ------------------- | ------------------------------------------------------------ |
| **/usr/include**    | Header files used to compile applications                    |
| **/usr/lib**        | Libraries for programs in **/usr/bin** and **/usr/sbin**     |
| **/usr/lib64**      | 64-bit libraries for 64-bit programs in **/usr/bin** and **/usr/sbin** |
| **/usr/sbin**       | Non-essential system binaries, such as system daemons        |
| **/usr/share**      | Shared data used by applications, generally architecture-independent |
| **/usr/src**        | Source code, usually for the Linux kernel                    |
| **/usr/local**      | Data and programs specific to the local machine. Subdirectories include **bin**, **sbin**, **lib**, **share**, **include**, etc. |
| **/usr/bin**        | This is the primary directory of executable commands on the system |

### Home

`~`'s value is given in the HOME variable.\
App config files are stored as dotfiles in `~`, increasingly in `~/.config ~/.cache ~.local`.\

### Rights
Giving permissions - `ugo rwx` - https://www.comentum.com/unix-osx-permissions.html\
