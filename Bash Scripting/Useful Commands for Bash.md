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

### apt; apt-get

### checkinstall
When compiling from source\
Compare with make install\
http://checkinstall.izto.org/; https://en.wikipedia.org/wiki/CheckInstall 

### touch
Compare with cat

### locate
Compare with find

### whereis

### whoami

### which

### history

### bash; ($0); $0; /bin/bash
Starts a subshell in exisiting shell\
To test whether PPID
`ssh-agent bash -c 'ssh-add private-key && do_something_else` - If you add the `-c` option, the argument following `-c` needs to be in quotes and acts like a mini-script
## Getting help
### info
### man
### tldr
A more concise version of man

## Managing processes
### top
`top, ps aux | grep process_name` 
### killall
`killall –9 process_name`
### ps
