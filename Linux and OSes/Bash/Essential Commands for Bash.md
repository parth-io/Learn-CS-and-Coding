# Essential Commands for Bash

[TOC]

### Command

Description\
*Further links/explanation*\
`Sample use of the command` - supporting explanation

## Directory Commands
### pwd
**P**rint current **W**orking **D**irectory to show you which directory you are currently in 
### ls
**L**i**S**t files in your current directory 
### cd
**C**hange **D**irectory\
`cd -` - go to former working directory\
If no pathname is specified, `cd` assumes you means the current working directory, i.e., the pathname begins with `./path_to_directory`
### mkdir
**M**a**K**e sub**DIR**ectory
### rmdir
**R**e**M**ove empty sub**DIR**ectory\
`rm -vrf` - to recursively remove files and folders from non-empty directories in verbose format, ignoring non-existent files and arguments

## Root

### sudo - i; sudo -s

After successful login, the $ prompt would change to # to indicate that you logged in as root user on Ubuntu

## File Commands

### cp
Copy
### mv
Move
### rm
Delete file

## Commands to display text files
### cat
To string together or display (**CAT**enate) the contents of files onto the screen 
### less
Variant of "cat" that includes features to read each page leisurely)\ 
In "less", use <space> to move down one page, 'b' to move Back up one page, and 'q' to Quit. You can also use the up/down arrow keys to move one line at a time.
### more
This baby existed before `less`, it has fewer features than `less` and [is slower than `less` as it loads the entire file at once](https://www.tecmint.com/linux-more-command-and-less-command-examples/#:~:text=Learn%20Linux%20'less'%20Command,using%20page%20up%2Fdown%20keys.), but its implementation is only 2000 lines as compared to `less`'s implementation, which is over 25000 lines\
Some systems hardlink `more` to `less`\
For more details, see [this](https://unix.stackexchange.com/questions/604/isnt-less-just-more).
### most
Ah, another one purporting to be more than `less`. See [this](https://unix.stackexchange.com/questions/81129/what-are-the-differences-between-most-more-and-less).
## Useful sequences of keys for vim

### i
To enter INSERT mode

### \<ESC>
To enter COMMAND mode

### \<ESC>:wq\<ENTER>
Saves your program and exits vim
### \<ESC>ZZ 
(Note that the Zs are uppercase) Saves your program and exits
### \<ESC>:q!\<ENTER>
Exits from vim without saving your program.
### \<ESC>ZQ
Exits from vim without saving your program.

## For more vim commands, go to this [reference](https://github.com/parth-io/Learn-CS-and-Coding/blob/master/Bash%20Scripting/vimqrc.pdf).
