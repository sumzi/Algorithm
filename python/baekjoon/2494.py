import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**9)
def digits(pos,turn):
    if pos==n:
        return 0
    if dp[pos][turn]!=-1:
        return dp[pos][turn]
    cur=(a[pos]+turn)%10
    l=(b[pos]-cur+10)%10
    lcnt=digits(pos+1,(turn+l)%10)+l
    r=(cur-b[pos]+10)%10
    rcnt=digits(pos+1,turn)+r

    if lcnt<rcnt:
        dp[pos][turn]=lcnt
        route[pos][turn]=l
    else:
        dp[pos][turn]=rcnt
        route[pos][turn]=-r

    return min(lcnt,rcnt)

def trace(pos,turn):
    if pos==n:
        return
    if route[pos][turn]!=0:
        print(pos+1,route[pos][turn])
    if route[pos][turn]>0:
        trace(pos+1,(turn+route[pos][turn]+10)%10)
    else:
        trace(pos+1,turn)

n=int(input())
a=list(map(int,input().strip()))
b=list(map(int,input().strip()))
dp=[[-1]*10 for i in range(10001)]
route=[[0]*10 for i in range(10001)]
print(digits(0,0))
trace(0,0)