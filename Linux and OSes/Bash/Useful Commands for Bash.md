# Useful Commands for Bash

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

### chmod; chown

### su; sudo

### mount

### apt; apt-get

### checkinstall
When compiling from source\
Compare with make install\
http://checkinstall.izto.org/; https://en.wikipedia.org/wiki/CheckInstall 

### touch
Compare with cat

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

## Computer Info
### uname
### dmesg
To access kernel logs
### Check if your laptop is 32 or 64-bit
`grep -qP '^flags\s*:.*\blm\b' /proc/cpuinfo && echo 64-bit || echo 32-bit`

## Managing files
### locate; find
### wildcards

## Managing file content
### cat
### touch
### head
### tail
### less; more; most
### nano; vi; vim
### grep

## Managing text
### sed
### cut
### spell
### sort

## Getting help
### info
### man
### tldr
A more concise version of man

## Managing processes
### top
`top | grep process_name` 
### killall; kill
`killall –9 process_name`\
TERM - terminate gracefully\
KILL - force kill
### ps
`ps aux`
### jobs
### fg; bg
`fg/bg %job-number` - restore job to foreground or background\
The Ctrl + Z key combination pauses the prcess and resumes control of the command line.

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
