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

### File Descriptors

Represent file streams

0, 1, 2 - stdin, stdout, stderrr

3, 4, ... - files

### Permissions

Owners - user, group, others

Permissions - read, write, execute

For executable files, setuid and setgid bits will allow any user to execute the program with the rights of the owner or the group, respectively. Ensure a setuid root program is secure and reliable before granting it permissions.

#### Root

`sudo -i`

`sudo -s`

`su -`

The -i option tells sudo to run the shell specified by the root user’s password database entry as a login shell. If you pass the -s to the sudo command, it runs the shell specified by the SHELL  environment variable if it exists or the shell defined by the invoking  user’s password database entry.

`su`  vs `sudo` - Google it!

#### Directories

For directories, read allows you to consult the list of contents, write create or delete files, and execute cross through the directory to access contents. Execute permission without read permission allows you to access contents whose names are known to you.

The setgid bit also applies to directories. Any newly-created item in such directories is automatically assigned the owner group of the parent directory, instead of inheriting the creator’s main group as per usual. Because of this, you don’t have to change your main group (with the `newgrp` command) when working in a file tree shared between several users of the same dedicated group. The sticky bit is a permission that is only useful in directories. It is especially used for temporary directories where everybody has write access (such as `/tmp/`): it restricts deletion of files so that only their owner or the owner of the parent directory can delete them. Lacking this, everyone could delete other users’ files in `/tmp/`.

#### Representing rights

For each category of users `u,g,o`, set permissions `rwx`  with `=/-/+`. Example - `u=rwx,g+rw,o-r`. Use `a` for all users if you wish. Permissions `s` for setuid and  `t` for sticky bits also exist.

An alternative way is to use octals - 4 for read, 2 for write, and 1 for execute. The sum of the octals gives the permissions. `chmod 754 file` gives all permissions to the owner, read and execute to the group, and read to others.

To represent special rights, you can prefix a fourth digit to this number according to the same principle, where the setuid, setgid, and sticky bits are 4, 2, and 1, respectively. The command `chmod 7544` will associate the setuid bit with the previously described rights. Note that the use of octal notation only allows you to set all the rights at once on a file; you must take into account the existing rights and compute the new corresponding numerical value. 

The octal representation is also used with the `umask` command, which is used to restrict permissions on newly created files. When an application creates a file, it assigns indicative permissions, knowing that the system automatically removes the rights defined with `umask`. Entering `umask` gives the mask, for example, `0022`. This is simply an octal representation of the rights to be systematically removed (in this case, the write rights for the group and other users). If you give it a new octal value, the umask command modifies the mask. Used in a shell initialization file (for example, ~/.bash_profile), it will effectively change the default mask for your work sessions.

Sometimes we have to change rights for an entire file tree using `-R` to operate recursively in sub-directories. When doing so, the distinction between directories and files can be avoided with `X`.  `chmod -R a+X` directory will only add execute rights for all categories of users for all sub-directories, and in the case of files, for which at least one category of user (even if their sole owner) already has execute rights.

https://unix.stackexchange.com/questions/416877/what-is-a-capital-x-in-posix-chmod

https://unix.stackexchange.com/questions/90306/is-there-a-flag-corresponding-to-x-x-but-for-s-with-chmod-on-linux

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

## Miscellaneous

### Passing Output as Commands

https://stackoverflow.com/questions/33431842/how-to-pass-command-output-as-multiple-arguments-to-another-command

https://stackoverflow.com/questions/6833582/pass-output-as-an-argument-for-cp-in-bash

https://unix.stackexchange.com/questions/585430/whats-currently-the-most-efficient-way-to-copy-paste-output-of-ls-into-anothe?newreg=428f4781d6c14719860abb004c631e5c - see my answer lol