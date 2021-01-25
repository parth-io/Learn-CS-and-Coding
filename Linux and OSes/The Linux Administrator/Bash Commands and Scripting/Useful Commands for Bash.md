# Useful Commands for Bash

Useful shell tips - https://tldp.org/LDP/GNU-Linux-Tools-Summary/html/c1195.htm

When using the `less` command (`man` uses `less` as its paginator), type `h` to see all the possible keyboard shortcuts. Typing `/text` searches for the specified text.

Some extremely useful shortcuts for Bash - https://ostechnix.com/list-useful-bash-keyboard-shortcuts/

```
ctrl-c
    interrupts the running programctrl-d    sends an EOF (end of file) to close the terminal
ctrl-z
    suspends the running program
ctrl-s
    freezes the screen, stopping the display
ctrl-q
    thaws out the screen and allows the screen display to continue
ctrl-h
    deletes the last character typed
ctrl-w
    deletes the last word typed
ctrl-u
    deletes from beginning of the line to cursor position
ctrl-r
    retrieves previously run commands so you can run them again
ctrl-u
    removes text from the command line and places it in the clipboard
ctrl-y
    grabs text from the clipboard and runs it
ctrl-l
    clears the screenctrl-a    moves cursor to the beginning of the linectrl-e    moves cursor to the end of the line
ctrl-a
	goes to the beginning of the line
ctrl-e
	goes to the end of the line
ctrl-d
    exits the current shell
tab
	Auto-complete feature for directories, filenames, and binaries!
```

Executing previous commands

1. `$ !!` - executes the previous command
2. `!$` - refers to the last argument in a line
3. `!n` - n^th command
4. `!string` - most recent command starting with `string`

## How to Use

These are some of the more essential commands any Linux user/administrator will encounter. Examples are given in `inline code`.

From the Table of Contents above, find a random comment, Google it (or read the `man`  page, practise with it in your shell, commit to memory.  Simple? You wish.

[TOC]

## Random

### checkinstall

When compiling from source
Compare with make install
http://checkinstall.izto.org/; https://en.wikipedia.org/wiki/CheckInstall 

### hash

### whereis; which

Generally for bash, `whereis` > `which`

Alternative to `whereis` include `find` and `locate`

### editor

### shutdown; poweroff; halt; reboot

### sensible-pager; sensible-browser; sensible-editor

## Managing Standard I/O and Arguments

### xargs
Reads items from standard input as arguments for a command
`xargs -n 1 curl -O < urls-to-download.txt`- when you want to use curl to download from multiple URLs\
`echo 'one two three' | xargs mkdir` - creates three folders\
`ls ‘one two three.txt’ ‘four.txt’ find . -name ‘*.txt’ | xargs -d ‘\n’ rm`- when filenames contains spaces you need to use -d option to change delimiter\
`find /tmp -mtime +14 | xargs rm` - files older than two weeks in the temp folder are found then removed

### tee

### getopt; getopts

Used to parse command options and arguments
`getopts` is defined by POSIX - be sure that it runs on any system running bash in POSIX mode (e.g., set -o posix)), but it does not support long options
getopt supports long options, but is system-specific
More detailed explanation - [https://www.computerhope.com/unix/bash/getopts.htm](https://www.computerhope.com/unix/bash/getopts.htm), https://wiki.bash-hackers.org/howto/getopts_tutorial

## Time and Date

### date

### cal

### time

## Using bash

### clear

### history

### su; sudo

### apt; apt-get

`apt-get -f install` - to install unsatisfied dependencies
`apt-rdepends; apt-cache` - some other low-level `apt` tools

### echo

`echo $?` - Gets the exit status of the last run command

`echo string >> file`

### bash

Starts a subshell in exisiting shell\
See [Scripting Notes](https://github.com/parth-io/Learn-CS-and-Coding/blob/master/Bash%20Scripting/Scripting%20Notes.md#shells-bash) for more details

## Managing drives

### fdisk; cfdisk 

### mount

`sudo mount /dev/sda5 /home`

Edit /etc/fstab to auto-mount

### dd

Versatile tool: can be used for managing file systems, system-related tasks, backup, and even text manipulation! See https://linuxconfig.org/learning-linux-commands-dd
Might need root permissions\
If copying to a USB, ensure that the USB key is unused; make sure that none of its partitions are mounted.\
The command also assumes that it is run while in the directory hosting the ISO image or file to be copied, otherwise the full path will need to be provided.

## System Info, Logs, and Hardware

### free

`free -m/-g`

### df

`df -h || df -Th`

### id

### uname

`uname -a`

### lsb_release

### hostnamectl

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

### file

Determines the nature of files, as in Linux the file extension is not meaningful (.txt files might actually be scripts)

### locate; find

https://unix.stackexchange.com/questions/60205/locate-vs-find-usage-pros-and-cons-of-each-other

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

### ln

To create hard links

`ln -s` - soft links

`ls -li` - this will help you check

### ls -l; stat

To view permissions

### gzip; bzip2; xz; zip; tar

| **Command** | **Usage**                                                    |
| ----------- | ------------------------------------------------------------ |
| `gzip`      | The most frequently used Linux compression utility -  `gzip *`, `gunzip foo`; `gzip -r dir` |
| `bzip2`     | Produces files significantly smaller than those produced by gzip - `bzip2` |
| `xz`        | Most space-efficient, mainly used to compress the kernel - `xz foo`, `xz -dk foo.xz #decompress but do not remove`, `xz -dcf 1.txt 2.txt.xz > 3.txt`, `xz -d *.xz` |
| `zip`       | Is often required to examine and decompress archives from other operating systems |
| `tar`       | Used to group files in an archive (and then (un)compress the whole archive at once) - `tar -xvf mydir.tar #extract files in tar into ./mydir`; `tar -xvzf mydir.tar.gz`; `tar jcvf mydir.tar.gz mydir #for bzip2` |

More efficient techniques take longer, but decompression time does not vary as much across different methods.

## Editing and Viewing Files

### cat; tac

`cat > file` - Standard input will end once you type Ctrl + D

`cat > file << EOF` - Standard input will end once you type EOF

### touch

### head; tail

`tail -f`

### less; more; most
### nano; vi; vim; emacs; ed; gedit

CLI editors, except for `gedit`

### grep

`grep -C 3 [pattern] file_name` - print the context of matched lines, in this case print 3 lines above and below the matched line

`grep [0-9] file_name` - print lines containing the numbers 0 through 9man

### z* bz* xz*

For compressed files

`zdiff; zgrep; zless; zcat; bzcat; xzcat`

## Managing text and file content

### uniq

Removes consecutive duplicate lines in a file
Equivalent to `sort -u`

Run `sort` before `uniq`  - `sort file | uniq > file2`

### paste; join

Used to combine entries (lines or fields) of 2 or more files

`join` is an advanced version of `paste` as it checks for duplicate fields across files 

### split

### spell
### sort

## Getting help
### info

To navigate, use 'n', 'p', 'u'. '*' denotes links and '::'  denotes named items outside a menu

### man; apropos; whatis

https://www.cs.mcgill.ca/~guide/help/man.html

`man intro; man man; man bash`

`man -a`

`man -wK`

`man -k` and `apropos` are equivalent

### tldr
A more concise version of man

### type

Used to find out if the command is a shell built-in or external binary

### help

For shell built-ins

`help command_name; command_name --help; command -V command_name`

`help` lists all shell builtins and is equivalent to `compgen; enable -a`

## Managing permissions

### chown

`chown user:group file` - to change both the user and group of a file at the same time

`# chown root:root file` - change both user and group to root

### chgrp

### chmod

`chmod u+x, g-w, o=r file`

`chmod uo+x, g+w file`

`chmod 754 file` 

### newgrp

## Managing Users and Groups

### who

### whoami

If you ever forget who you are

### id

`id -nG`

### groups

### getent

`getent group group_name`

## Managing Processes

### top; htop; atop
`top | grep process_name` 

See top's manual page Section 4a for interactive keys such as 'k', 'f'

### killall; kill; pkill; xkill
`killall –9 process_name`

`kill -signal PID`- PID is Process Identifier, and signal is TERM, KILL, etc.
`kill -9 PID`1

TERM - terminate gracefully
KILL - force kill

You can also use `top` and press `k` to enter in the PID.

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

### pgrep; pidof

## Managing Variables
### printenv
To print environmental variables
### env
To modify environmental variables
### set
Anything to do with shell variables
`set -o posix; set` - to view shell variables but not shell functions, by setting it to POSIX mode

## Networking
### wget; curl

https://daniel.haxx.se/docs/curl-vs-wget.html
Use `wget` if you are conducting large files; recursive; password-locked; multiple file downloads

`curl -o file_name url`

### ifconfig; ip

`ifconfig` is older than `ip`

`ip route get 8.8.8.8``
``ip address`

Might need to run it as root or as follows on some distributions (`adress` is the object, `show` the (optional) command):
`/sbin/ip address show`

### ping

If there is something wrong with your DNS set-up, you will get an unknown host message or (sometimes) it appears to connect to the site but is actually a self-feedback loop where the address is 127.0.x.x

### hostname
