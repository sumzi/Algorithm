import sys
input=sys.stdin.readline
INF=sys.maxsize

t=int(input())
while t>0:
    n=int(input())
    m=list(map(int,input().split()))
    s=[0]
    dp=[[0]*(n+1) for i in range(n+1)]
    for i in m:
        s.append(s[-1]+i)
    for i in range(1,n):
        for j in range(1,n-i+1):
            end=j+i
            dp[j][end]=INF
            for k in range(j,end):
                dp[j][end]=min(dp[j][end],dp[j][k]+dp[k+1][end]+s[end]-s[j-1])
    print(dp[1][n])
    t-=1 