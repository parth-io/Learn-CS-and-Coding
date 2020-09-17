# Scripting Notes

### Quoting
[From the Bash manual](https://www.gnu.org/software/bash/manual/html_node/Quoting.html#Quoting)\
https://unix.stackexchange.com/questions/503013/what-is-the-difference-between-and-quotes

### eval
Used to execute arguments as shell commands\
Useful when you wish to run a program or command that needs to modify the parent process\
**How does it work**\
As programs or commands are run as child processes and hence cannot modify parent processes, we use functions instead, as functions run in the current process.
`eval $(ssh-agent)`

### Creating Shell and Environmental Variables
When creating a shell variable `shell_variable='Hello World`, ensure it does not clash with an existing environmental variable by running `printenv | grep shell_variable`.\
Shell variables are limited to the parent shell. After creating the variable, running `bash -c 'echo $shell_variable` will not return anything.\
To create environmental variables, use `export`.\
`unset` will remove the variable, shell or environmental.\
`export -n` will demote an environmental to a shell variable.\

### Login vs Non-login & Interactive vs Non-interactive
A **login** shell is a shell session that begins by authenticating the user. If you are signing into a terminal session or through SSH and authenticate, your shell session will be set as a “login” shell. If you start a new shell session from within your authenticated session, a **non-login** shell session is started.\
An **interactive** shell session is a shell session that is attached to a terminal. A **non-interactive** shell session is one is not attached to a terminal session.

## Shells, Subshells and Child Processes

### Shells (bash)
bash; ($0); $0; /bin/bash
```
$ bash -c 'echo "\$0=$0, \$1=$1, \$2=$2"' zero one two
$0=zero, $1=one, $2=two
```
To test whether PPID\
`ssh-agent bash -c 'ssh-add private-key && do_something_else` - If you add the `-c` option, the argument following `-c` needs to be in quotes and acts like a mini-script

### Subshells
Equivalent forms to spawn subshells
`bash && echo $shell_variable`
`(echo $shell_variable)`
`bash -c 'echo $shell_variable`
