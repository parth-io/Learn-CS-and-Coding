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

A process is not the same as a program or command
Types of processes- threads, kernel thread, daemons, interactive and batch processes
Scheduler in kernel allocates processes to CPU
Running, sleep
PID, PPID, TID, UID (RUID and EUID), GID (RGID and EGID)
Priority of processes - nice values range from -20 to +19 (lowest), you can also assign real-time priority
Multitasking and multiple processor cores

#### Load average

Average of load number
Considers running, queued, sleeping processes (including uninterruptible sleepers)

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

## User Environments

### Root

`sudo` is meant for a temporary basis, for a specific subset of commands. To enter `#` mode in bash, enter either one of  following:

1. `sudo -i`
2. ``sudo -s`
3. `su - #su means switch user. Usually, the other user is root. By default, a lot of distributions do not set a root account, hence the su command will be unable to authenticate`

The -i option tells sudo to run the shell specified by the root user’s password database entry as a login shell. If you pass the -s to the sudo command, it runs the shell specified by the SHELL  environment variable if it exists or the shell defined by the invoking  user’s password database entry.

`su`  vs `sudo` - Google it!

### Start-up

When you first login to Linux, /etc/profile is read and evaluated. Then the following files are searched (if they exist) in the listed order:

1. 1. 1. ~/.bash_profile
      2. ~/.bash_login
      3. ~/.profile 

where  ~/. denotes the user's home directory. The Linux login shell evaluates whatever startup file that it comes across first and ignores the rest. This means that if it finds ~/.bash_profile, it ignores ~/.bash_login and ~/.profile. Recent distributions sometimes do not even have .bash_profile and/or .bash_login , and some just do little more than include .bashrc.

However, every time you create a new shell, or terminal window, etc., you do not perform a full system login; only a file named ~/.bashrc file is read and evaluated. Although this file is not read and evaluated along with the login shell, most distributions and/or users include the ~/.bashrc file from within one of the three user-owned startup files.

Most commonly, users only fiddle with ~/.bashrc, as it is invoked every time a new command line shell initiates, or another program is launched from a terminal window, while the other files are read and executed only when the user first logs onto the system.

### Aliases

You can create customized commands, shortcut references to commands, or modify the behavior of already existing ones by creating aliases. Most often, these aliases are placed in your ~/.bashrc file so they are available to any command shells you create. 

`unalias` removes an alias.  `alias`  will list currently defined aliases.

### Users and Groups

All Linux users are assigned a unique user ID (uid), which is just an integer; normal users start with a uid of 1000 or greater.

Users also have one or more group IDs (gid), including a default one which is the same as the user ID. Linux uses groups for organizing users. Groups are used to establish a set of users who have common interests for the purposes of access rights, privileges, and security  considerations. 

To control group membership, see the /etc/group file. By default, every user belongs to a default or primary group. When a user logs in, the group membership is set for their primary group and all the members enjoy the same level of access and privilege.

Also see the /etc/passwd file

#### Adding and Removing Users

`# useradd user #sets home directory /home/user, modifies /etc/passwd``
``# userdel user #use -r to remove /home directory` 
`# usermod``
``$ id`

#### Adding and Removing Groups

`# groupadd``
``# groupdel``
``$ group user #see what group the user belongs to``
``# usermod -a -G group_to_be_added_to user``
``# groupmod`

## Shells

### Variables

#### Shell Variables

| **Task**                              | **Command** |
| ------------------------------------- | ----------- |
| Show the value of a specific variable | `echo $var` |

When creating a shell variable `shell_variable='Hello World`, ensure it does not clash with an existing environmental variable by running `printenv | grep shell_variable`.
Shell variables are limited to the parent shell, not even child processes can modify or set them. After creating the variable, running `bash -c 'echo $shell_variable` will not return anything.

#### Environmental Variables

Environmental variables are specific values used by the shell, preset by system or startup scripts

Environmental variables are also created when shell variables are made global by the `export` command

1. Bash as login shell will load `/etc/profile`, `~/.bash_profile`, `~/.bash_login`, `~/.profile` in the order
2. Bash as non-login interactive shell will load `~/.bashrc`
3. Bash as non-login non-interactive shell will load the configuration specified in environment variable `$BASH_ENV`

| **Task**                                                     | **Command**                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Check currently set environmental variables                  | `set`, `env`, `printenv` or `export`                         |
| Add an environmental variable **permanently to any and all new shell processes** | Add the line "export var=value" to ~/.bashrc **(but this only works for interactive shells)** or edit /etc/environment or edit /etc/profile (for login shells, need to use `export`)  **See bookmarks, this is way too complicated** |
| Create an environmental variable from a shell variable **only for the current shell processes and any child shells **(See below for why) | `var=value; export var` or `export var=value`                |
| Demote an environmental to a shell variable                  | `export -n`                                                  |
| Remove the shell or environmental variable                   | `unset`                                                      |

By default, the variables created within a script are available only to the subsequent steps of that script. Any child processes (sub-shells) do not have automatic access to the values of these variables. To make them available to child processes, they must be promoted to environment variables as shown. 
While child processes are allowed to modify the value of exported variables, the parent will not see any changes; exported variables are not shared, they are only copied and inherited.

##### HOME

`~`'s value is given in the HOME variable.
App config files are stored as dotfiles in `~`, increasingly in `~/.config ~/.cache ~.local`.

##### PATH

`export PATH=$HOME/bin:$PATH`

An empty (null) directory name indicates the current directory at any given time. For example, there is a null directory before path1 in :path1:path2 and a null directory after path1 in path1::path2

##### SHELL

##### PS1

Refers to prompt statement, used to customise the terminal's prompt string

My current PS1 (add this via `export` in ~/.bashrc) (`!` prints the history number) - `PS1='\[\e]0;\u@\h: \w\a\]${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\t on \d, \!@\u\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '`
Old - `PS1='\[\e]0;\u@\h: \w\a\]${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\u@\h\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '`

##### HIST*

In ~/.bashrc, I added the following lines:
HISTCONTROL=ignoreboth:erasedups
HISTIGNORE="ls*":"man*":"exit":"history*"

### Login vs Non-login & Interactive vs Non-interactive

A **login** shell is a shell session that begins by authenticating the user. If you are signing into a terminal session or through SSH and authenticate, your shell session will be set as a “login” shell. If you start a new shell session from within your authenticated session, a **non-login** shell session is started.\
An **interactive** shell session is a shell session that is attached to a terminal. A **non-interactive** shell session is one is not attached to a terminal session.

### Built-ins

https://www.thegeekstuff.com/2010/08/bash-shell-builtin-commands/
https://www.gnu.org/software/bash/manual/html_node/Shell-Builtin-Commands.html
`set` - change shell attributes, options, and positional parameters
`type command_name` and `command -V command_name` will give you information on whether `command_name` is a built-in

### Command search and execution

If the script/command is in `$PATH`, then run `script`, else run `./script`
https://pubs.opengroup.org/onlinepubs/9699919799/utilities/V3_chap02.html#tag_18_09_01_01

### `source` command

`source command` vs `./command` - `source` is used to load and execute the contents of a file in the current shell process. Why not just execute the file? Because executing as a script will load the commands in a new shell process, preventing you from changing environmental variables in the current shell

[POSIX-compliant version](https://pubs.opengroup.org/onlinepubs/9699919799/utilities/V3_chap02.html#dot) - instead of `source file`, type `. file`

### Subshells and Child Processes

#### Beware inheritance of shell and environmental variables across childshells, subshells, and child processes

#### Shells (bash)

$0; /bin/bash

```
$ bash -c 'echo "\$0=$0, \$1=$1, \$2=$2"' zero one two
$0=zero, $1=one, $2=two
```

`ssh-agent bash -c 'ssh-add private-key && do_something_else` - If you add the `-c` option, the argument following `-c` needs to be in quotes and acts like a mini-script. The arguments following the mini-script are assigned to the positional parameters ($0, $1, ...).

#### Subshells

Running a shell script creates a new process called subshell; a subshell can be used to do parallel processing; if you start another shell on top of your current shell, it can be referred to as a subshell.
`echo $BASH_SUBSHELL` - the subshell level you are at
Run `ps -f` to check the PID and PPID. The PPID of the child process/subshell should be the same as the PID of the parent.\
Equivalent forms to spawn subshells **(careful, some forms will terminate the subshell after the command is executed)**

```
$ bash
$ bash -c '...'
$ $0
$ /bin/bash
$ ( ... ) #Creates a subshell; useful for grouping commands together
$ $( ... ) #Command substitution
$ 
```

https://unix.stackexchange.com/questions/138463/do-parentheses-really-put-the-command-in-a-subshell
https://unix.stackexchange.com/questions/524506/how-can-i-detect-if-im-in-a-subshell?noredirect=1&lq=1
https://unix.stackexchange.com/questions/421020/what-is-the-exact-difference-between-a-subshell-and-a-child-process?noredirect=1&lq=1
https://unix.stackexchange.com/questions/261638/is-a-sub-shell-the-same-thing-as-a-child-shell
https://unix.stackexchange.com/questions/430050/why-doesnt-spawn-a-new-child-process-when-run-in-background?noredirect=1&lq=1
https://unix.stackexchange.com/questions/358850/what-are-all-the-ways-to-create-a-subshell-in-bash?noredirect=1&lq=1
https://unix.stackexchange.com/questions/442692/is-a-subshell
https://bash.cyberciti.biz/guide/What_is_a_Subshell%3F
https://www.linuxtopia.org/online_books/advanced_bash_scripting_guide/subshells.html
https://bash.cyberciti.biz/guide/What_is_a_Subshell%3F
https://stackoverflow.com/questions/34799161/difference-between-linux-variables-bash-subshell-vs-shlvl
https://unix.stackexchange.com/questions/329117/why-does-the-value-of-bash-subshell-not-change-while-the-value-of-shlvl-changes
https://unix.stackexchange.com/questions/560162/how-to-show-how-many-times-bash-has-been-invoked

#### Child Processes

## Manipulating text

### sed

### awk

## Permissions

`chmod`, `chown`, `chgrp`

Owners - user, group, others - `ugo`

Permissions - read, write, execute - `rwx`

For executable files, setuid and setgid bits will allow any user to execute the program with the rights of the owner or the group, respectively. Ensure a setuid root program is secure and reliable before granting it permissions.

https://blog.ssdnodes.com/blog/linux-permissions/

```bash
$ ls -l
1999999999 2 3 4 4096 Jun 10 00:01 file
$ # 1 is where the character for the Unix file type will be, the next 9 characters are rwxrwxrwx, or rwx for ugo, then 2 is the number of hard links for the file, 3 is owner, 4 is the group
```

### Directories

For directories, read allows you to consult the list of contents, write create or delete files, and execute cross through the directory to access contents. Execute permission without read permission allows you to access contents whose names are known to you.

The setgid bit also applies to directories. Any newly-created item in such directories is automatically assigned the owner group of the parent directory, instead of inheriting the creator’s main group as per usual. Because of this, you don’t have to change your main group (with the `newgrp` command) when working in a file tree shared between several users of the same dedicated group.

 The sticky bit is a permission that is only useful in directories. It is especially used for temporary directories where everybody has write access (such as `/tmp/`): it restricts deletion of files so that only their owner or the owner of the parent directory can delete them. Lacking this, everyone could delete other users’ files in `/tmp/`.

### Representing rights

https://www.comentum.com/unix-osx-permissions.html

For each category of users `u,g,o`, set permissions `rwx`  with `=/-/+`. Example - `u=rwx,g+rw,o-r`. Use `a` for all users if you wish. Permissions `s` for setuid and  `t` for sticky bits also exist.

An alternative way is to use octals - 4 for read, 2 for write, and 1 for execute. The sum of the octals gives the permissions. `chmod 754 file` gives all permissions to the owner, read and execute to the group, and read to others.

To represent special rights, you can prefix a fourth digit to this number according to the same principle, where the setuid, setgid, and sticky bits are 4, 2, and 1, respectively. The command `chmod 7544` will associate the setuid bit with the previously described rights. Note that the use of octal notation only allows you to set all the rights at once on a file; you must take into account the existing rights and compute the new corresponding numerical value. 

The octal representation is also used with the `umask` command, which is used to restrict permissions on newly created files. When an application creates a file, it assigns indicative permissions, knowing that the system automatically removes the rights defined with `umask`. Entering `umask` gives the mask, for example, `0022`. This is simply an octal representation of the rights to be systematically removed (in this case, the write rights for the group and other users). If you give it a new octal value, the umask command modifies the mask. Used in a shell initialization file (for example, ~/.bash_profile), it will effectively change the default mask for your work sessions.

Sometimes we have to change rights for an entire file tree using `-R` to operate recursively in sub-directories. When doing so, the distinction between directories and files can be avoided with `X`.  `chmod -R a+X` directory will only add execute rights for all categories of users for all sub-directories, and in the case of files, for which at least one category of user (even if their sole owner) already has execute rights.

https://unix.stackexchange.com/questions/416877/what-is-a-capital-x-in-posix-chmod

https://unix.stackexchange.com/questions/90306/is-there-a-flag-corresponding-to-x-x-but-for-s-with-chmod-on-linux

## Linux File System

### Filesystem Hierarchy Standard 

### .d convention

If a directory ends in .d, it just means that it is a directory. Lol.
See /etc/sudoers and /etc/sudoers.d/
For example, /etc/sudoers.d/ contains files and scripts relevant to /etc/sudoers/
Why this .d convention? No damn clue

### /proc

Contain virtual files (files that exist only in memory) that mimic kernel structures and configuration information permit viewing constantly changing kernel data and runtime system information, e.g. system memory, devices mounted, hardware configuration, etc.

### /dev

The /dev directory contains device nodes, a type of pseudo-file used by most hardware and software devices, except for network devices. This directory is:

- Empty on the disk partition when it is not mounted

- Contains entries which are created by the udev system, which creates and manages device nodes on Linux, creating them dynamically when devices are found. The /dev directory contains items such as /dev/sda1 and /dev/random (a source of random numbers)

### /var

The /var directory contains files that are expected to change in size and content as the system is running (var stands for variable), such as system log files in /var/log, print queues in /var/spool/, network services directories in /var/ftp and /var/www (the HTTP web service), and packages and database files in /var/lib.

The /var directory may be put on its own filesystem so that any exploding file sizes do not fatally affect the system.

### /etc

Contains system config files and global startup files for all users
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

## Networking

IP addresses
Information exchange consists of data buffers and headers
IPv4 and IPv6
NAT
Classes A, B, C, D, E
DHCP and static addresses
Name Resolution
Subnet
Classless Inter-Domain Routing