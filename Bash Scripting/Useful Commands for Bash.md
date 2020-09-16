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

### time

### fdisk; cfdisk 

### chmod; chown

### su; sudo

### apt; apt-get

### checkinstall
When compiling from source\
Compare with make install\
http://checkinstall.izto.org/; https://en.wikipedia.org/wiki/CheckInstall 

## Managing processes
### top
`top, ps aux | grep process_name` 
### killall
`killall –9 process_name`

### touch
Compare with cat

### locate
Compare with find

### whereis

### whoami

### which

## Getting help
### info
### man
### tldr
A more concise version of man

### history
