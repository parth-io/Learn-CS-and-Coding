rom - https://stackoverflow.com/questions/26130909/bash-output-column-formatting
Also see - https://unix.stackexchange.com/questions/59249/print-output-to-3-separate-columns

#Script 1
#!/bin/bash
file="/Users/USER12/Desktop/url-list.txt"
log="/Users/USER12/Desktop/url-results.txt"
fmt="%-25s%-12s%-12s\n"
printf "$fmt" DOMAIN_NAME HTTP_CODE RESPONSE_TIME > "$log"
while read line
do
    read code time < <(curl -o /dev/null --silent --head --write-out '%{http_code} %{time_total}' "$line")
    printf "$fmt" "$line" "$code" "$time" >> "$log"
done <"$file"

#Script 2 - more concise version
#!/bin/bash

file="./url.txt"
fmt="%s\t%s\t%s\n"
( printf "$fmt" "DOMAIN_NAME" "HTTP_CODE" "RESPONSE_TIME"
while read -r line
do
    printf "$fmt" "$line" $(curl -o /dev/null --silent --head --write-out '%{http_code} %{time_total}' "$line")
done <"$file" ) | column -t > ./out.txt

#The above 2 codes open and close the log file with each loop. This can be avoided by using exec to redirect stdout to the log file before the first printf statement.

#Script 3
#!/bin/bash
file="/Users/USER12/Desktop/url-list.txt"
exec >"/Users/USER12/Desktop/url-results.txt"
fmt="%-25s%-12s%-12s\n"
printf "$fmt" DOMAIN_NAME HTTP_CODE RESPONSE_TIME
while read line
do
    read code time < <(curl -o /dev/null --silent --head --write-out '%{http_code} %{time_total}' "$line")
    printf "$fmt" "$line" "$code" "$time"
done <"$file"

#Or group the print statements, which also helpfully restores stdout to its normal value.

#Script 4
#!/bin/bash
file="/Users/USER12/Desktop/url-list.txt"
fmt="%-25s%-12s%-12s\n"
{
printf "$fmt" DOMAIN_NAME HTTP_CODE RESPONSE_TIME
while read line
do
    read code time < <(curl -o /dev/null --silent --head --write-out '%{http_code} %{time_total}' "$line")
    printf "$fmt" "$line" "$code" "$time"
done <"$file"
} >"/Users/USER12/Desktop/url-results.txt"
