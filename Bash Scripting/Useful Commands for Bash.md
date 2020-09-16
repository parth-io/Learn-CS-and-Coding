# Useful Commands for Bash

### Command
Description\
*Further links/explanation*\
`Sample use of the command` - supporting explanation

### xargs
Reads items from standard input as separated by blanks and executes a command once for each argument

**Example**
`xargs -n 1 curl -O < urls-to-download.txt`- when you want to use curl to download from multiple URLs\
`echo 'one two three' | xargs mkdir` - creates three folders\
When filenames contains spaces you need to use -d option to change delimiter

ls ‘one two three.txt’ ‘four.txt’ find . -name ‘*.txt’ | xargs -d ‘\n’ rm
`find /tmp -mtime +14 | xargs rm` - files older than two weeks in the temp folder are found then removed

### getopt; getopts
Used to parse command options and arguements (getopts is defined by POSIX (be sure that it runs on any system running bash in POSIX mode (e.g., set -o posix)), but does not support long options - getopt supports long, but is system specific) (https://www.computerhope.com/unix/bash/getopts.htm)

### shift

### time
