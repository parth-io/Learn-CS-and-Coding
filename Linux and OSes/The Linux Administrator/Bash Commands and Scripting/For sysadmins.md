# Interesting Commands

### type
Used to understand how its keyword would be translated if passed as a command, and if the command is a shell builtin or external binary

### ioctl

### loginctl

`loginctl show-session $(loginctl | grep $(whoami) | awk '{print $1}') -p`

### systemctl

`sudo systemctl stop gdm` - to stop display manager

### telinit (for System V, so outdated)