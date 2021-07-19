n,k=map(int,input().split())
bag=[]
for i in range(n):
  bag.append(list(map(int,input().split())))
dp=[[0]*(100001) for i in range(101)]
for i in range(n):
  for j in range(1,k+1):
    if bag[i][0]<=j:
      dp[i+1][j]=max(dp[i][j],dp[i][j-bag[i][0]]+bag[i][1])
    else:
      dp[i+1][j]=dp[i][j]
print(dp[n][k])