#Given a time in 12-hour AM/PM format, convert it to military (24-hour) time. Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock. 
#!/bin/python3

import os
import sys 

if __name__ == '__main__':
    s = str(input())
    x = s.split(':')
    x[2].rstrip('M')
    if 'P' in x[2]:
        if x[0] == "12":
            x[0] = "00"
        print(str(int(x[0]) + 12) + ":" + x[1] + ":" + x[2].rstrip('PM'))   
    else:
        if x[0] == "12":
            x[0] = "00"
        print(x[0] + ":" + x[1] + ":" + x[2].rstrip('AM'))
 
