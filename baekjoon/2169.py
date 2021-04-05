n,m=map(int,input().split())
INF=-(10**9)
worth=[list(map(int,input().split())) for i in range(n)]
dp=[[[INF]*m for i in range(n)] for i in range(3)]

dp[0][0][0]=worth[0][0]
for j in range(1,m):
  dp[0][0][j]=dp[0][0][j-1]+worth[0][j]
for i in range(1,n):
  # 왼->오
  dp[1][i][0]=dp[0][i-1][0]+worth[i][0]
  for j in range(1,m):
    dp[1][i][j]=max(dp[0][i-1][j],dp[1][i][j-1])+worth[i][j]
  #왼<-오
  dp[2][i][m-1]=dp[0][i-1][m-1]+worth[i][m-1]
  for j in range(m-2,-1,-1):
    dp[2][i][j]=max(dp[0][i-1][j],dp[2][i][j+1])+worth[i][j]
  for j in range(m):
    dp[0][i][j]=max(dp[1][i][j],dp[2][i][j])
print(dp[0][n-1][m-1])