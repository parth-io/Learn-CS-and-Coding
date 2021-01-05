# Some Interesting Commands

### -dry-run

For many utilities, you can test your command first

## System

### ioctl

### loginctl

`loginctl show-session $(loginctl | grep $(whoami) | awk '{print $1}') -p`

### systemctl

`sudo systemctl stop gdm` - to stop display manager

### telinit (for System V, so outdated)

### udev

https://opensource.com/article/18/11/udev

### visudo

https://www.digitalocean.com/community/tutorials/how-to-edit-the-sudoers-file

`man sudoers`

### at

Schedule future processes

```bash
$ at now + 2 days #when
at> cat file1.txt #what
at> <EOT> # Ctrl + D
```

### cron

Time-based scheduling utility program to launch routine background jobs at specific times and/or days

`crontab -e ` will open the crontab editor to edit existing jobs or to create new jobs. See the configuration file at /etc/crontab for details of job definitions. The config file also contains the various shell commands that need to be run at scheduled times. There are both system-wide crontab files and individual user-based ones. * symbolises 'for all values of the field'.

### sleep

### systemctl start nfs

#### Server

/etc/exports contains directories and permissions that a host is willing to share over NFS. A sample entry:

/projects *.example.com(rw)

After modifying /etc/exports/, type`exportfs -av` to notify Linux about the directories you are allowing to be remotely mounted using NFS. You can also restart NFS with `sudo systemctl restart nfs`, but this is heavier, as it halts NFS for a short while before starting it up again. 

To make sure the NFS service starts whenever the system is booted, issue `sudo systemctl enable nfs`.

#### Client

On the client machine, if it is desired to have the remote filesystem mounted automatically upon system boot, /etc/fstab is modified to accomplish this.

servername:/projects /mnt/nfs/projects nfs defaults 0 0

You can also mount the remote filesystem without a reboot or as a one-time mount by directly using `mount`:

`$ sudo mount servername:/projects /mnt/nfs/projects`

Furthermore, you may want to use the nofail option in fstab in case the NFS server is not live at boot.

## File

### patch

When distributing modifications to source code and config files

Produce patch files by running `$ diff -Nur originalfile newfile > patchfile`

To apply a patch, do either `$ patch -p1 < patchfile` or  `$ patch originalfile patchfile.`The first usage is often used to apply changes to an entire directory tree, rather than just one file, as in the second usage.

### rsync

Locations are designated in the target:path form, where target can be in the form of someone@host. The someone@ part is optional and used if the remote user is different from the local user.

`$ rsync -r project-X archive-machine:archives/project-X`