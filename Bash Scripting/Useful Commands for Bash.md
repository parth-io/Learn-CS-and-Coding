# Useful Commands for Bash

## xargs

When you want to use curl to download from multiple URLs
**Example**
xargs -n 1 curl -O < urls-to-download.txt

### getopt; getopts
Used to parse command options and arguements (getopts is defined by POSIX (be sure that it runs on any system running bash in POSIX mode (e.g., set -o posix)), but does not support long options - getopt supports long, but is system specific) (https://www.computerhope.com/unix/bash/getopts.htm)

**xargs**
When you want to use curl to download from multiple URLs
#### Example
xargs

**getopt; getopts**
Used to parse command options and arguements (getopts is defined by POSIX (be sure that it runs on any system running bash in POSIX mode (e.g., set -o posix)), but does not support long options - getopt supports long, but is system specific) (https://www.computerhope.com/unix/bash/getopts.htm)
