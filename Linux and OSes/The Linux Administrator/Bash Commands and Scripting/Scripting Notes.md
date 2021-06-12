# Scripting Notes

## This is just a quick recap of what I learnt, see a proper tutorial to learn about shell scripts properly and comprehensively

[TOC]

### `man bash`

`man bash` has a lot of interesting commands and builtins.\
For example, `$?`.

### Constructs, Conditionals, and Statements

```bash
if then elif else fi # you can write this in one-line also - if [[ condition ]] ; then execute_command ; fi
do done
for # https://www.cyberciti.biz/faq/bash-for-loop/
while
until
case esac # see below
case "$var" in
	"arg1" ) ...;;
	"arg2" | "arg3" ) ...;;
	* ) ...;; # for any other response
```

### File Descriptors

Represent file streams and I/O resources like pipes

0, 1, 2 - stdin, stdout, stderrr

3, 4, ... - files

### Operators

#### The best resource - https://unix.stackexchange.com/questions/159513/what-are-the-shells-control-and-redirection-operators (Read it once, read it twice, ... bloody hell just reread all the answers)
#### Special Characters

`&   &&   (   )   ;   ;;   <newline>   |   || \ # ;`
`|&` - only for bash
`!` - it is a Reserved Word that acts as a NOT operator in test constructs and arithmetic expressions
`\` concatenates multiple lines and is used at the end of a line to indicate continuation on to the next line (most useful in improving readability when a single command spans multiple lines)
The nifty `;`  allows you to write multiple commands on the same line
`&&` - command chaining; the AND operator
`||` - OR operator

` command&` - run command in background

#### Piping and redirection

Piping is for piping streams of text (STDIN, STDOUT, STDERR) from one process or program to another; redirection is for redirecting streams of text to/from files from/to streams of texts.

`<     >     >|     <<     >>     <&     >&     <<-     <>`
In the case of passing input to echo and other similar commands that cannot process standard input:

```
cat my_file.txt | xargs echo 
echo $(<my_file.txt) #This is called input redirection
echo "$(cat my_file.txt)"
```

To redirect STDERR to a file such as `/dev/null`, write `program 2> /dev/null`
To redirect both STDERR and STDOUT to a file in a POSIX-compliant way, write `program > file 2>&1`
**(Not recommended)** To redirect both STDERR and STDOUT using bash-only extensions, use `program >& file` or `program &> file`
https://unix.stackexchange.com/a/563563/443433
`&` in I/O redirection and in `2>&1`'s' case tells us that `1` is a file descriptor, not a file. `&` in `&>` or `>&`'s case is not significant, it is just a bash construction.

`wc < /etc/passwd` and `cat /etc/passwd | wc` are equivalent

Redirection can be bidirectional: `sort < fileName.txt > sortNewFile.txt`

Remember to type Ctrl + D if you have to, to signify the end of standard input

#### Other Random Characters

`\command_name` - putting a backslash before a command - this is equivalent to the 3 following forms: `command command_name; "commandname" (...); /usr/bin/command_name`. What this does is prevent the aliased version of the command from running, but only for interactive shells (not for scripts)

Single quotes - placing text in single quotes removes the special meaning of meta-characters - they just become literal
Double quotes (weak quoting) - placing text in double quotes turns off the meaning of all characters except $, ', ", and \
https://www.grymoire.com/Unix/Quote.html#toc-uh-0

More details than you would ever need - https://www.austintripp.ca/blog/2019/07/18/bash-quotes

`quote; shell-quote` - obscure command - https://askubuntu.com/questions/354915/quote-command-in-the-shell

`{...}` 

`[...]` - equivalent  to `test`, see the manual page for `bash` and `test`

`[[...]]` - more capable than `[...]` but not POSIX-compliant

Links that explain in-depth about other characters
https://unix.stackexchange.com/questions/306111/what-is-the-difference-between-the-bash-operators-vs-vs-vs
https://stackoverflow.com/questions/30106758/difference-between-braces-and-brackets-in-shell-scripting
https://stackoverflow.com/questions/12765340/difference-in-bash-between-if-statements-with-parenthesis-and-square-brackets
https://stackoverflow.com/questions/2188199/how-to-use-double-or-single-brackets-parentheses-curly-braces
https://www.linux.com/training-tutorials/using-square-brackets-bash-part-2/ (see the whole series of articles, scroll to the bottom)

For more details about square brackets (some answers in the links are quite informative):
https://stackoverflow.com/questions/17992711/brackets-difference-and-usage-in-bash
https://stackoverflow.com/questions/3427872/whats-the-difference-between-and-in-bash/3427931#3427931
https://stackoverflow.com/questions/669452/is-double-square-brackets-preferable-over-single-square-brackets-in-ba
https://stackoverflow.com/questions/9581064/why-should-there-be-spaces-around-and-in-bash
http://mywiki.wooledge.org/BashFAQ/031
https://unix.stackexchange.com/questions/32210/why-does-parameter-expansion-with-spaces-without-quotes-work-inside-double-brack
https://unix.stackexchange.com/questions/99185/what-do-square-brackets-mean-without-the-if-on-the-left

Also, `$RANDOM` is random

### Functions/Subroutines

function () {
	echo $1
}
function lol

The above script will print "lol" lol.

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

```bash
$ cat << EOF > file.txt
foo1
foo2
foo3
EOF
$ touch file
$ echo foo > file.txt
```

### Working with directories

`pushd; popd` are useful commands to remember directories
https://unix.stackexchange.com/questions/77077/how-do-i-use-pushd-and-popd-commands
See `cd`'s use cases in Essential Commands

### mktemp

If you regularly create temporary files and directories, attackers can guess predictable names and file locations. Use `mktemp` to create random and unpredictable filenames for temporary storage.

### Programmable Completion Builtins

`compgen; complete; compopt`

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

### Debugging

```
$ bash –x ./script_file # run the bash script in debug mode 
```

Else you can bracket specific parts of the script with `set -x` and `set +x`.

### Array variables

Subscripts - @ vs *
https://www.gnu.org/software/bash/manual/bash.html#Arrays
https://stackoverflow.com/questions/16627986/bash-array-variables-or

### eval
Used to execute arguments as shell commands
Useful when you wish to run a program or command that needs to modify the parent process
**How does it work**
As programs or commands are run as child processes and hence cannot modify parent processes, we use functions instead, as functions run in the current process.
`eval $(ssh-agent)`

https://en.wikipedia.org/wiki/Regular_expression#POSIX_basic_and_extended

### Learning printf with awk
https://unix.stackexchange.com/questions/443578/pass-arguments-from-previous-commands-pipes-to-awk-printf-function-and-format
https://stackoverflow.com/questions/6462894/how-can-i-format-the-output-of-a-bash-command-in-neat-columns

### exec
To replace the shell with a command - in effect, redirecting output to the command
https://askubuntu.com/questions/525767/what-does-an-exec-command-do

### Locales

LC_ALL = C - https://unix.stackexchange.com/a/87763/443433

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

### String Manipulation

```
length_of_string = $(#string)
[[ string1 > string2 ]]
${string:offset:n} # to extract n characters from a string, beginning from the offset character; to extract all characters in a string after a dot (.), use the following expression: ${string#*.}
```

### Arithmetic Expressions

`expr` is deprecated
You can do `var = $((...)); echo $((...))) ` or `let x=(...); echo $x`

### = vs ==

`==` is preferred over `=` even though both yield the same result

### Return values

`exit N` - `N` is the exit status number, if not included `exit` will give the return status of the most recent command

`echo $?` gives the exit status of the most recently-run program

### --

The double dash is used after commands to signify that there will be no more options inputted.

- used to let the command know that the argument to the command is not an option, if the argument starts with a dash.
- also used to prevent malicious files named "--recursive" or "--verbose"

`rm -- *.txt`
`for f in *[A-Z]* ; do mv -i -- "$f" "${f,,}"; done`

### Handling Positional Parameters

https://wiki.bash-hackers.org/scripting/posparams

### $0, $1, $2, $*, $#

#### $0

It expands to the name of the shell or shell script, set at shell initialization.
If Bash is invoked by a script, $0 is set to the name of that file.
If Bash is started with the -c option, then $0 is set to the first argument after the string to be executed, if one is present.
Otherwise, it is set to the filename used to invoke Bash, as given by argument zero.

#### $1, $2, ...

First parameter passed to the script at the command-line, second parameter, ...

#### $*

All parameters

#### $#

Number of arguments

#### getopts; getopt

See 'Useful Commands'

### shift

https://unix.stackexchange.com/questions/174566/what-is-the-purpose-of-using-shift-in-shell-scripts
https://www.gnu.org/savannah-checkouts/gnu/bash/manual/bash.html#index-shift
Shift vs for loops - https://docstore.mik.ua/orelly/unix3/upt/ch35_22.htm

## Miscellaneous

### Passing Output as Commands

https://stackoverflow.com/questions/33431842/how-to-pass-command-output-as-multiple-arguments-to-another-command

https://stackoverflow.com/questions/6833582/pass-output-as-an-argument-for-cp-in-bash

https://unix.stackexchange.com/questions/585430/whats-currently-the-most-efficient-way-to-copy-paste-output-of-ls-into-anothe?newreg=428f4781d6c14719860abb004c631e5c - see my answer lol

### Getting the size of the terminal
echo $LINES, $COLUMNS
tput cols, tput lines
stty size
