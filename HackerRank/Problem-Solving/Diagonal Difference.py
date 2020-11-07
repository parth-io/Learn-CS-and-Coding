#Given a square matrix, calculate the absolute difference between the sums of its diagonals. 
#!/bin/python3

import math
import os
import random
import re
import sys

def diagonalDifference(arr):
    # Write your code here
    sum_i = 0
    sum_j = 0
    x = 0
    y = 0
    total = 0
    for i in range(0, n):
        sum_i += arr[i][i]
        sum_j += arr[i][-(i+1)]
    total = sum_i - sum_j
    if total < 0:
        total = - total
    return total

if __name__ == '__main__':

    n = int(input().strip())

    arr = []

    for _ in range(n):
        arr.append(list(map(int, input().rstrip().split())))

    print(diagonalDifference(arr))
 
