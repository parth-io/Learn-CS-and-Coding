# Useful Commands for Bash

[TOC]



### Command

Description\
*Further links/explanation*\
`Sample use of the command` - supporting explanation

### xargs
Reads items from standard input as separated by blanks and executes a command once for each argument
`xargs -n 1 curl -O < urls-to-download.txt`- when you want to use curl to download from multiple URLs\
`echo 'one two three' | xargs mkdir` - creates three folders\
`ls ‘one two three.txt’ ‘four.txt’ find . -name ‘*.txt’ | xargs -d ‘\n’ rm`- when filenames contains spaces you need to use -d option to change delimiter\
`find /tmp -mtime +14 | xargs rm` - files older than two weeks in the temp folder are found then removed

### getopt; getopts
Used to parse command options and arguements\
getopts is defined by POSIX - be sure that it runs on any system running bash in POSIX mode (e.g., set -o posix)), but it does not support long options\
getopt supports long options, but is system-specific\
More detailed explanation - [https://www.computerhope.com/unix/bash/getopts.htm](https://www.computerhope.com/unix/bash/getopts.htm)

### shift
https://unix.stackexchange.com/questions/174566/what-is-the-purpose-of-using-shift-in-shell-scripts
https://www.gnu.org/savannah-checkouts/gnu/bash/manual/bash.html#index-shift
Shift vs for loops - https://docstore.mik.ua/orelly/unix3/upt/ch35_22.htm

### time

### fdisk; cfdisk 

### su; sudo

### mount

`sudo mount /dev/sda5 /home`

Edit /etc/fstab to auto-mount

### apt; apt-get

### checkinstall
When compiling from source\
Compare with make install\
http://checkinstall.izto.org/; https://en.wikipedia.org/wiki/CheckInstall 

### hash

### whereis

### editor

### whoami

### which

### echo $?
Gets the exit status of the last run command

### bash
Starts a subshell in exisiting shell\
See [Scripting Notes](https://github.com/parth-io/Learn-CS-and-Coding/blob/master/Bash%20Scripting/Scripting%20Notes.md#shells-bash) for more details

### dd
https://linuxconfig.org/learning-linux-commands-dd\
Might need root permissions\
If copying to a USB, ensure that the USB key is unused; make sure that none of its partitions are mounted.\
The command also assumes that it is run while in the directory hosting the ISO image or file to be copied, otherwise the full path will need to be provided.

### shutdown; poweroff; halt; reboot

## System Info, Logs, and Hardware

### free

`free -m/-g`

### df

`df -h || df -Th`

### id

### uname

`uname -a`

### dmesg
To access kernel logs

### journalctl

`journalctl -r` - reverse the order of systemd's journal logs

`journalctl -f` - print new logs continuously as they are appended

### lshw

Hardware details are found in the `/proc/` and `/sys/` filesystems\

`lshw` combines the 4 following individual commands, with `lsdev` for communications resources used by devices

#### lspci; lsusb; lspcmcia; lsdev

### Check if your laptop is 32 or 64-bit
`grep -qP '^flags\s*:.*\blm\b' /proc/cpuinfo && echo 64-bit || echo 32-bit`

## Managing filesystems and files (you can use wildcards like ?, *, [])

### tree

Gives a recursive overview of the filesystem

### pushd; popd; dirs

Advanced `cd`

### diff

To compare 3 files - `diff3`

### cmp

Just like diff, except it is meant for for binary files

### locate; find

http://www.hypexr.org/linux_find_help.php

Find a file "foo.bar" that exists somewhere in the filesystem - `$ find / -name foo.bar -print` (*On most platforms the -print is optional, however, on some Unix systems nothing will be output without it. `find` searches recursively through all directories.*)

Find a file without searching network or mounted filesystems - `$ find / -name foo.bar -print -xdev` (*This can increase search speed greatly if the mounted filesystem is large or over a slow network. "-mount" does the same thing as "-xdev" for compatibility with other versions of find.*)

Find a file without showing "Permission Denied" messages - `$ find / -name foo.bar -print 2>/dev/null`

Find a file, who's name ends with .bar, within the current directory and only search 2 directories deep - `$ find . -name *.bar -maxdepth 2 -print`

Search directories "./dir1" and "./dir2" for a file "foo.bar - `$ find ./dir1 ./dir2 -name foo.bar -print`

Search for files that are owned by the user "joebob" - `$ find /some/directory -user joebob -print` (*You can use `-uid -gid -group` also.*)

Find a file that is a certain type. "-type l" searches for symbolic links - `$ find /some/directory -type l -print` (b - block (buffered) special; c - character (unbuffered) special; d - directory; p -  named pipe (FIFO); f - regular file; l - symbolic link; s - socket)

Search for directories that contain the phrase "foo" but do not end in ".bar" - `$ find . -name '*foo*' ! -name '*.bar' -type d -print`

#### The power of `find`

`find` becomes extremely useful when combined with other commands. One such combination would be using `find` and `grep` together.

`$ find ~/documents -type f -name '*.txt' \ -exec grep -s DOGS {} \; -print`

This sequence looks in /users/home/directory/documents for a file (*-type f*) with a name ending in .txt. It sends the files it finds to the `grep` command via the `-exec` option to search the file found for any occurrences of the word "DOG". If the file is found it will be output to the screen and if the word "DOG" is found, within one of the found files, the line that "DOG" occurs in will also be output to the screen.

`find -name "\*.swp" -exec/ok rm {} ’;’`

{} are placeholders that will be filled with all the file names  that result from the find expression, and the preceding command will be  run on each one individually.

End the command with either ‘;’ (including the single-quotes) or "\;". Both forms are fine.

### chmod; chown

### ln

To create hard links

`ln -s` - soft links

`ls -li` - this will help you check

### ls -l; stat

To view permissions

## Managing file content

### cat; tac
### touch
### head; tail
### less; more; most
### nano; vi; vim; emacs; ed; gedit

CLI editors

### grep

## Managing text
### sed
### cut
### spell
### sort

## Getting help
### info

To navigate, use 'n', 'p', 'u'. '*' denotes links and '::'  denotes named items outside a menu

### man; apropos; whatis

`man -a`

### tldr
A more concise version of man

### help

`help`

`help -name_of_command`

## Managing permissions

### chown

`chown user:group file` - to change both the user and group of a file at the same time

### chgrp

### chmod

### newgrp

## Managing processes

### top; htop; atop
`top | grep process_name` 

See top's manual page Section 4a for interactive keys such as 'k', 'f'

### killall; kill
`killall –9 process_name`

`kill -signal PID`- PID is Process Identifier, and signal is TERM, KILL, etc.\

TERM - terminate gracefully\
KILL - force kill

### ps
BSD style - `ps aux/axo`

`ps -eLf`

### pstree

### jobs

Lists background processes

### fg; bg
To run a command in the background and resume control of the shell, type  `&`  after the command\

`fg %job-number` - to restore a command/job running in the background to the foreground\
The Ctrl + Z key combination pauses a foreground job and resumes control of the command line, Ctrl + C will terminate\

`bg %job-number` - restart the process in the background

### renice

`ps lf` to see processes' priorities then run `renice priority PID`

### w; uptime; top

To get load average

## Managing variables
### printenv
To print environmental variables
### env
To modify environmental variables
### set
Anything to do with shell variables
`set -o posix; set` - to view shell variables but not shell functions, by setting it to POSIX mode

## Introductory terminal commands
### clear
### date
### cal
### history

## Networking
### wget; curl
### ifconfig
### ping
