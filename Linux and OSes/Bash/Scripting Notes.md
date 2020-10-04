# Scripting Notes

[TOC]

### `man bash`

`man bash` has a lot of interesting commands and builtins.\
For example, `$?`.

### Operators

#### The best resource - https://unix.stackexchange.com/questions/159513/what-are-the-shells-control-and-redirection-operators (Read it once, read it twice, ... bloody hell just reread it)
#### Control operators
`&   &&   (   )   ;   ;;   <newline>   |   ||`\
`|&` - only for bash\
`!` - it is a Reserved Word that acts as a NOT operator in test constructs and arithmetic expressions\

` command &` - run command in background\
#### Piping and redirection
`<     >     >|     <<     >>     <&     >&     <<-     <>`\
In the case of passing input to echo and other similar commands that cannot process standard input:
```
cat my_file.txt | xargs echo 
echo $(<my_file.txt) #This is called input redirection
echo "$(cat my_file.txt)"
```

### Passing data/string to a command instead of a file
https://unix.stackexchange.com/questions/505828/how-to-pass-a-string-to-a-command-that-expects-a-file
https://unix.stackexchange.com/questions/16990/using-data-read-from-a-pipe-instead-than-from-a-file-in-command-options

### Reading user input
`read -e var_to_store_user_input` is used for bash shells. To adhere to POSIX, see https://unix.stackexchange.com/questions/399930/is-there-a-posix-shell-alternative-to-read-e and https://unix.stackexchange.com/questions/112109/using-shells-read-command-with-live-editing-functionality-readline-like.

### Changing the case of alphabetic characters
Use {Variable,,} or {Variable^^}. See the 'Parameter Expansion' heading in `man bash`. 

### Quoting
[From the Bash manual](https://www.gnu.org/software/bash/manual/html_node/Quoting.html#Quoting)\
https://unix.stackexchange.com/questions/503013/what-is-the-difference-between-and-quotes

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

### Creating Shell and Environmental Variables
When creating a shell variable `shell_variable='Hello World`, ensure it does not clash with an existing environmental variable by running `printenv | grep shell_variable`.\
Shell variables are limited to the parent shell. After creating the variable, running `bash -c 'echo $shell_variable` will not return anything.\
To create environmental variables, use `export`.\
`unset` will remove the variable, shell or environmental.\
`export -n` will demote an environmental to a shell variable.\

### Login vs Non-login & Interactive vs Non-interactive
A **login** shell is a shell session that begins by authenticating the user. If you are signing into a terminal session or through SSH and authenticate, your shell session will be set as a “login” shell. If you start a new shell session from within your authenticated session, a **non-login** shell session is started.\
An **interactive** shell session is a shell session that is attached to a terminal. A **non-interactive** shell session is one is not attached to a terminal session.

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

## Shells, Subshells and Child Processes

### Shells (bash)
$0; /bin/bash
```
$ bash -c 'echo "\$0=$0, \$1=$1, \$2=$2"' zero one two
$0=zero, $1=one, $2=two
```
`ssh-agent bash -c 'ssh-add private-key && do_something_else` - If you add the `-c` option, the argument following `-c` needs to be in quotes and acts like a mini-script. The arguments following the mini-script are assigned to the positional parameters ($0, $1, ...).

### Subshells
Running a shell script creates a new process called subshell; a subshell can be used to do parallel processing; if you start another shell on top of your current shell, it can be referred to as a subshell.
`echo $BASH_SUBSHELL` - the subshell level you are at
Run `ps -f` to check the PID and PPID. The PPID of the child process/subshell should be the same as the PID of the parent.\
Equivalent forms to spawn subshells **(careful, some forms will terminate the subshell after the command is executed)**
```
$ bash
$ bash -c '...'
$ $0
$ /bin/bash
$ ( ... ) #Creates a subshell; useful for grouping commands together
$ $( ... ) #Command substitution
$ 
```
https://unix.stackexchange.com/questions/138463/do-parentheses-really-put-the-command-in-a-subshell
https://unix.stackexchange.com/questions/524506/how-can-i-detect-if-im-in-a-subshell?noredirect=1&lq=1
https://unix.stackexchange.com/questions/421020/what-is-the-exact-difference-between-a-subshell-and-a-child-process?noredirect=1&lq=1
https://unix.stackexchange.com/questions/261638/is-a-sub-shell-the-same-thing-as-a-child-shell
https://unix.stackexchange.com/questions/430050/why-doesnt-spawn-a-new-child-process-when-run-in-background?noredirect=1&lq=1
https://unix.stackexchange.com/questions/358850/what-are-all-the-ways-to-create-a-subshell-in-bash?noredirect=1&lq=1
https://unix.stackexchange.com/questions/442692/is-a-subshell
https://bash.cyberciti.biz/guide/What_is_a_Subshell%3F
https://www.linuxtopia.org/online_books/advanced_bash_scripting_guide/subshells.html
https://bash.cyberciti.biz/guide/What_is_a_Subshell%3F
https://stackoverflow.com/questions/34799161/difference-between-linux-variables-bash-subshell-vs-shlvl
https://unix.stackexchange.com/questions/329117/why-does-the-value-of-bash-subshell-not-change-while-the-value-of-shlvl-changes
https://unix.stackexchange.com/questions/560162/how-to-show-how-many-times-bash-has-been-invoked
### Sourcing vs Subshells
https://superuser.com/questions/176783/what-is-the-difference-between-executing-a-bash-script-vs-sourcing-it

### Child Processes
