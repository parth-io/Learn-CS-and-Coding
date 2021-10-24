#!/bin/bash
for i in ./*; do
    if [ -d "$i" ]; then
        ln -s "$(pwd)/${i:2}" "/home/parth/Desktop/${i:2}"
    fi
done
