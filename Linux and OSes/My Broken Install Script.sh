export HISTIGNORE='*sudo -S*'

echo "your_password" | sudo -S #lol that's my password please hack into my system

sudo add-apt-repository ppa:slgobinath/safeeyes

## Typora
wget -qO - https://typora.io/linux/public-key.asc | sudo apt-key add -
sudo add-apt-repository 'deb https://typora.io/linux ./'

## Calibre
sudo -v && wget --no-check-certificate -nv -O- https://download.calibre-ebook.com/linux-installer.sh | sudo sh /dev/stdin

sudo apt update && sudo apt install -y safeeyes htop nmap typora scrcpy sl cmake build-essential && sudo snap install p3x-onenote spotify authy
sudo wget -O /etc/bash.command-not-found https://raw.githubusercontent.com/hkbakke/bash-insulter/master/src/bash.command-not-found
exit 0

# PS1='\[\e]0;\u@\h: \w\a\]${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\t on \d, \!@\u\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ ' Old - PS1='\[\e]0;\u@\h: \w\a\]${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\u@\h\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '

# In ~/.bashrc, I edited the following lines: 
# HISTCONTROL=ignoreboth:erasedups 
# HISTIGNORE="ls*":"man*":"exit":"history*":"shutdown*":"reboot"

#Write code to do the stuff below automatically!
#sudo visudo --> Defaults       insults
#download fortune-mod tarball --> fortune -o --> offensive
#ensure cmake is installed --> extract tarball --> cd ./extracted folder --> mkdir build --> cd ./build --> cmake .. --> cd .. --> cmake --build build --> sudo cmake -install --build

#Add the lines below to .bashrc
# if [ -f /etc/bash.command-not-found ]; then
#     . /etc/bash.command-not-found
# fi
# if (( "$LINES" > 20 )); then
#     randomNumber=$(shuf -i 1-10 -n 1)
#     if [ $randomNumber -ge 6 ]; then
#         echo "You bastard, you got lucky!"
#         echo
#         fortune -o
#         echo
#     elif [ $randomNumber -ge 5 ]; then
#         sl -e
#     else
#         fortune
#         echo
#     fi
# fi
# 
# export PS1='\[\e]0;\u@\h: \w\a\]${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\t on \d, \!@\u\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '
# alias luminus-downloader='cd /home/parth/Desktop/Luminus/luminus-downloader/ && node main.js'
# There is a hack here for the commands below here requiring sudo permission, but any administrator worth his salt will discount the security liability as not worth the convenience.
# As I am not worth my salt, I use that hack. But fortunately enough I didn't commit this hack to GitHub (or did I? Happy Easter Egg!)
# alias maxbrightness='sudo brightnessctl -d "intel_backlight" set 100%'
# alias minbrightness='sudo brightnessctl -d "intel_backlight" set 3%'
# alias 2brightness='sudo brightnessctl -d "intel_backlight" set 6%'
# alias 3brightness='sudo brightnessctl -d "intel_backlight" set 10%'
# alias custombrightness='sudo brightnessctl -d "intel_backlight" set 10%'
# alias singapore='sudo timedatectl set-timezone Singapore'
# alias atlantic='sudo timedatectl set-timezone Atlantic/Reykjavik'
# alias fuck-off="shutdown now"
