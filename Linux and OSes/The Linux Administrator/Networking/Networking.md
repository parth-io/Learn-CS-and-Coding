Some tools

1. network-manager-* (usually gnome)
2. ifupdown
   1. wpasupplicant
3. systemd-networkd
   1. See Chapter 5.1.3 of Kali Linux Revealed for details on usage

scp vs ssh vs sftp vs ftp 

 

SSH 

 

Learning SSH 

https://gist.github.com/loochao/037160d00560d152ee7bd7a62a554330 

https://www.ssh.com/ 

 

Adding a client for the first time 

1. https://stackoverflow.com/questions/3663895/ssh-the-authenticity-of-host-hostname-cant-be-established/35045005#35045005 
   1. Not advised - https://linuxcommando.blogspot.com/2008/10/how-to-disable-ssh-host-key-checking.html 
2. https://superuser.com/questions/421074/ssh-the-authenticity-of-host-host-cant-be-established/421084#421084 

 

Troubleshooting 

https://jrs-s.net/2017/07/01/slow-ssh-logins/ 

 

Understanding SSH CLI 

https://smallstep.com/blog/ssh-agent-explained/ 

https://www.ssh.com/ssh/agent 

https://superuser.com/questions/284374/ssh-keys-ssh-agent-bash-and-ssh-add 

. For future internet readers, if you're like me, you have a bunch of leftover ssh-agent processes from your previous attempts. "sudo killall ssh-agent" will kill all of them. 

https://askubuntu.com/questions/36255/why-wont-ssh-agent-save-my-unencrypted-key-for-later-use 

https://stackoverflow.com/questions/17846529/could-not-open-a-connection-to-your-authentication-agent/17848593#17848593 

https://unix.stackexchange.com/questions/48863/ssh-add-complains-could-not-open-a-connection-to-your-authentication-agent 

 

Usual steps to start ssh-agent and ssh-add 

eval $(ssh-agent) || ssh-agent bash 

ssh-add 

 

For an explanation on why we need eval, see your Scripting Notes  