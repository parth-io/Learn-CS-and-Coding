# Scripting Notes

[TOC]

### `man bash`

`man bash` has a lot of interesting commands and builtins.\
For example, `$?`.

### Operators

#### The best resource - https://unix.stackexchange.com/questions/159513/what-are-the-shells-control-and-redirection-operators (Read it once, read it twice, ... bloody hell just reread it)
Control operators

`&   &&   (   )   ;   ;;   <newline>   |   ||`\
`|&` - only for bash\
`!` - it is a Reserved Word that acts as a NOT operator in test constructs and arithmetic expressions\

` command &` - run command in background\

The nifty `;`  allows you to write multiple commands on the same line 

#### Piping and redirection

Piping is for piping streams of text (STDIN, STDOUT, STDERR) from one process or program to another; redirection is for redirecting streams of text to/from files from/to streams of texts.

`<     >     >|     <<     >>     <&     >&     <<-     <>`\
In the case of passing input to echo and other similar commands that cannot process standard input:

```
cat my_file.txt | xargs echo 
echo $(<my_file.txt) #This is called input redirection
echo "$(cat my_file.txt)"
```

To redirect STDERR to STDOUT, do `program > file 2>&1`

To redirect both STDERR and STDOUT, use `program >& file`

Redirection can be bidirectional: `sort < fileName.txt > sortNewFile.txt`

Remember to type Ctrl + D if you have to, to signify the end of standard input

### Process and Command Substitution

#### Process Substitution

https://tldp.org/LDP/abs/html/process-sub.html

#### Command Substitution

https://stackoverflow.com/questions/15416570/command-substitution-vs-process-substitution

https://unix.stackexchange.com/questions/393349/difference-between-subshells-and-process-substitution

#### Some niche cases

https://unix.stackexchange.com/questions/585430/whats-currently-the-most-efficient-way-to-copy-paste-output-of-ls-into-anothe/621337#621337

https://unix.stackexchange.com/questions/28503/how-can-i-send-stdout-to-multiple-commands

### Passing data/string to a command instead of a file

https://unix.stackexchange.com/questions/505828/how-to-pass-a-string-to-a-command-that-expects-a-file
https://unix.stackexchange.com/questions/16990/using-data-read-from-a-pipe-instead-than-from-a-file-in-command-options

### Creating a file

`echo foo > file.txt`, `echo foo >> file.txt`

```bash
$ cat << EOF > file.txt
foo1
foo2
foo3
EOF
$
```

### Reading user input
`read -e var_to_store_user_input` is used for bash shells. To adhere to POSIX, see https://unix.stackexchange.com/questions/399930/is-there-a-posix-shell-alternative-to-read-e and https://unix.stackexchange.com/questions/112109/using-shells-read-command-with-live-editing-functionality-readline-like.

### Changing the case of alphabetic characters
Use {Variable,,} or {Variable^^}. See the 'Parameter Expansion' heading in `man bash`. 

### Unicode support
Bash now supports both the UTF-8 hexadecimal encoding and Java/C++ escape sequence.
```
$ printf '\xC3\xAA'
ê
$ echo -e '\xC3\xAA'
ê
$ echo -e '\u00ea'
ê
```

### File Descriptors

Represent file streams

0, 1, 2 - stdin, stdout, stderrr

3, 4, ... - files

### Array variables

Subscripts - @ vs *
https://www.gnu.org/software/bash/manual/bash.html#Arrays
https://stackoverflow.com/questions/16627986/bash-array-variables-or

### eval
Used to execute arguments as shell commands\
Useful when you wish to run a program or command that needs to modify the parent process\
**How does it work**\
As programs or commands are run as child processes and hence cannot modify parent processes, we use functions instead, as functions run in the current process.
`eval $(ssh-agent)`

### Learning printf with awk
https://unix.stackexchange.com/questions/443578/pass-arguments-from-previous-commands-pipes-to-awk-printf-function-and-format
https://stackoverflow.com/questions/6462894/how-can-i-format-the-output-of-a-bash-command-in-neat-columns

### exec
To replace the shell with a command - in effect, redirecting output to the command
https://askubuntu.com/questions/525767/what-does-an-exec-command-do

### Locales

LC_ALL = C - https://unix.stackexchange.com/a/87763/443433

### $0
It expands to the name of the shell or shell script, set at shell initialization.\
If Bash is invoked by a script, $0 is set to the name of that file.\
If Bash is started with the -c option, then $0 is set to the first argument after the string to be executed, if one is present.\
Otherwise, it is set to the filename used to invoke Bash, as given by argument zero.

### Long and short options
https://stackoverflow.com/questions/10818443/short-long-options-with-option-argument-is-this-some-sort-of-convention
https://www.gnu.org/software/libc/manual/html_node/Argument-Syntax.html#Argument-Syntax
http://www.catb.org/~esr/writings/taoup/html/ch10s05.html
For tar - https://www.gnu.org/software/tar/manual/html_section/tar_21.html\
It should be explained that all of this is a matter of convention…there are MANY commands that allow (or REQUIRE) long-form names to use a single ‘-’ (“find”, for example), and many that don’t need either ‘-’ or ‘—’ and rely only on the positions of arguments alone to distinguish parameters from filenames (“tar” and “ar” for example).\
Some programs (for example “rm” - for removing a file) have problems distinguishing between a command line option (like “rm -f”) and a file that might possibly have a ‘-’ sign in it’s name.\
So - if, for example, you accidentally created a file called ‘-file’ - it would be impossible to delete it because ‘rm -file’ would think the ‘-file’ was a set of four command-line options and not a filename. Hence it offers the option to us ‘—’ to mean “this is the last command line option - what comes next is a filename”.

### Disambiguation
`${var}text` - Give me the contents of `var`, then followed by `text`\
Contrast with `$vartext`, which means give me the contents of vartext

### Shell equality operators and syntax
https://stackoverflow.com/questions/20449543/shell-equality-operators-eq
https://stackoverflow.com/questions/3427872/whats-the-difference-between-and-in-bash

## Miscellaneous

### Passing Output as Commands

https://stackoverflow.com/questions/33431842/how-to-pass-command-output-as-multiple-arguments-to-another-command

https://stackoverflow.com/questions/6833582/pass-output-as-an-argument-for-cp-in-bash

https://unix.stackexchange.com/questions/585430/whats-currently-the-most-efficient-way-to-copy-paste-output-of-ls-into-anothe?newreg=428f4781d6c14719860abb004c631e5c - see my answer lol