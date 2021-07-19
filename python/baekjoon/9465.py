import sys
input=sys.stdin.readline

t = int(input())
while t > 0:
    a = []
    n = int(input())
    a.append(list(map(int, input().split())))
    a.append(list(map(int, input().split())))
    dp = [[0, a[0][0]], [0, a[1][0]]]
    
    for i in range(2,n+1):
        tmp=max(dp[1][i-2],dp[1][i-1])+a[0][i-1]
        dp[0].append(tmp)
        tmp=max(dp[0][i-2],dp[0][i-1])+a[1][i-1]
        dp[1].append(tmp)
    print(max(dp[0][n],dp[1][n]))
    t-=1