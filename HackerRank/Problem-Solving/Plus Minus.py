#Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with places after the decimal.
#!/bin/python3

import math
import os
import random
import re
import sys
from decimal import *

# Complete the plusMinus function below.
def plusMinus(arr):
    z = 0
    p = 0
    ne = 0
    for x in arr:
        if x == 0:
            z += 1
        elif x > 0:
            p += 1
        else:
            ne += 1
    print(round(Decimal(p / n), 6))
    print(round(Decimal(ne / n), 6))
    print(round(Decimal(z / n), 6))
    
if __name__ == '__main__':
    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    plusMinus(arr)
 
