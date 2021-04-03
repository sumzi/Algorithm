n,m=map(int,input().split())
dp=[list(map(int,input().strip())) for i in range(n)]
res=0
for i in range(n):
  for j in range(m):
    if i>0 and j>0 and dp[i][j]==1:
      dp[i][j]+=min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])
    res=max(res,dp[i][j])
print(res*res)