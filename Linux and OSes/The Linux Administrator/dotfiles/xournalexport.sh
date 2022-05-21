#!/bin/bash
# NOT POSIX COMPLIANT
cd /media/parth/Dual/
#Delete the autosaved stuff, sometimes it picks up stufff in Trash-1000 so exclude that folder as it is from Windows
find ./ -type f -name '*autosave.xopp*' -not -path "./.Trash-1000/*" -print0 | while IFS= read -r -d '' filename; do
  rm "$filename"
done
# Expand recursively all directories
shopt -s nullglob globstar
arr=(**/*.xopp)
#readarray -d '' arr < <(find ./ -type f -name '*xopp*' -not -path "./.Trash-1000/*" -print0) 
# find ./ -type f -name '*xopp*' -not -path "./.Trash-1000/*" -print0 | while IFS= read -r -d '' filename; do
  # arr+=("$filename")
# done
IFS=$'\n'
for filename in ${arr[*]}; do
  BASE_FILENAME=$(basename "$filename" .xopp)
  CONTAINING_DIRECTORY=$(dirname "$filename")
  read -p "Convert $filename? (Y/N): " confirm  
  if [[ $confirm == [yY] || $confirm == [yY][eE][sS] ]]; then
    xournalpp -p "${CONTAINING_DIRECTORY}/${BASE_FILENAME}_.pdf" "$filename"
    if [[ $? == 0 ]]; then
        echo
        rm "$filename"
    else
        echo
        echo "***Failed to delete $filename***"
        echo
    fi
  fi
done
unset IFS
