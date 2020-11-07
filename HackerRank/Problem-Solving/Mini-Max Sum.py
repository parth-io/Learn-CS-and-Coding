#Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
#!/bin/python3

import math
import os
import random
import re
import sys

arr = list(map(int, input().rstrip().split()))

prr = sorted(arr)
prr.pop()
arr.sort(reverse=True)
arr.pop()
print(sum([x for x in prr]), sum([x for x in arr]))
