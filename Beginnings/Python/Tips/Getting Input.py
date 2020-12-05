## Sample main client
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    ar_count = int(input())

    ar = list(map(int, input().rstrip().split()))

    result = birthdayCakeCandles(ar)

    fptr.write(str(result) + '\n')

    fptr.close()
    
    
## Two ways to get unknown lines of input from user
while True:
    try:
        name = input()
        ## [...]
    except: break
^^Above code allows you to check the next line for input until there is no input on the next line because of the while True and the except: break.

lines = sys.stdin.readlines()
for i in lines:
    ## [...]
