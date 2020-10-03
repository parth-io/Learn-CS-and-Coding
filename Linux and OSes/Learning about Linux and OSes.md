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
PID number
Multitasking and multiple processor cores
### Permissions

## Command Line

### tty and the GUI
If you cannot access the GUI, use tty.\
https://ostechnix.com/how-to-switch-between-ttys-without-using-function-keys-in-linux/\
https://askubuntu.com/questions/66195/what-is-a-tty-and-how-do-i-access-a-tty

#### Booting into tty or into GUI
https://askubuntu.com/questions/825094/how-do-i-boot-directly-to-tty1-in-ubuntu\
startx has not been maintained for long - https://askubuntu.com/questions/436546/ubuntu-12-04-boots-to-tty1, https://askubuntu.com/questions/518454/what-does-startx-command-do

### Basics
Bash, zh, sh, ksh\
$ and #\
Bash commands are either shell builtins like `cd` and `pwd` or found at locations designated in the PATH environmental variable\
Environment variables store the global settings for the shell or other programs. They are contextual - each process has its own set of environment variables - but inheritable - shells, like login shells, can pass down variable to other programs they execute.\
Go to /etc/profile to change system settings or user-specific in ~/.profile but variables that are not specific to command line interpreters are better put in /etc/environment, since those variables will be injected into all user sessions thanks to a Pluggable Authentication Module (PAM) – even when no shell is executed.

## Linux File System

### Filesystem Hierarchy Standard 
### Home
`~`'s value is given in the HOME variable.\
App config files are stored as dotfiles in `~`, increasingly in `~/.config ~/.cache ~.local`.\

### Rights
Giving permissions - `ugo rwx` - https://www.comentum.com/unix-osx-permissions.html\
