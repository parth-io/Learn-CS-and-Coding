#Write a program that prints a staircase of size n using # and spaces.
#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the staircase function below.
def staircase(n):
    str = ""
    hash = ""
    for i in range((n - 1), -1, -1):
        str = " " * i
        hash = "#" * (n - i)
        print(str + hash)

if __name__ == '__main__':
    n = int(input())

    staircase(n)
 
