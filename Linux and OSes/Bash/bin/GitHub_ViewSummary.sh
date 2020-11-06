#!/bin/bash
printf "Printing some important info about your GitHub account status, gists, issues, PRs and releases!\n"
gh auth status
gh gist list
gh issue list
gh pr list
gh release list
printf "Do you want to view a summary of your repo?\nInput 'Y\N'\n"
read -e ANSWER
ANSWER={ANSWER^^}
if [ ANSWER=Y ]; then
    gh repo view
fi
exit 0
