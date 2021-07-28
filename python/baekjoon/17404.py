import sys
input=sys.stdin.readline
INF=sys.maxsize

n=int(input())
arr=[list(map(int,input().split())) for i in range(n)]
dp=[[0]*3 for i in range(n)]
ans=INF
for i in range(3):
    dp[0][0]=dp[0][1]=dp[0][2]=INF
    dp[0][i]=arr[0][i];
    for j in range(1,n):
        dp[j][0]=min(dp[j-1][1],dp[j-1][2])+arr[j][0]
        dp[j][1]=min(dp[j-1][0],dp[j-1][2])+arr[j][1]
        dp[j][2]=min(dp[j-1][0],dp[j-1][1])+arr[j][2]
    for j in range(3):
        if i==j: continue
        ans=min(ans,dp[n-1][j])
print(ans)