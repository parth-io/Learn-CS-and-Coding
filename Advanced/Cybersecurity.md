OSCP 

1) installing Kali Linux 2)Basic terms of cyber world 3) Basics of networking 4) Web exploits with step wise approach on a practice environment DVWA 5) Steganography related techniques 6) Wireless security 7) google dorks 8) OS detection / Scanning techniques - nmap 9) Few advance exploitation concepts/attacks - msf 10) google dorks 

 

https://www.hackthebox.eu/ 

 

[My OSCP Journey | cracked OSCP at 20](https://www.youtube.com/watch?v=fkNozXlrB6I) 

 

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

  