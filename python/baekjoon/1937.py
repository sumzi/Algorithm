import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**9)
def dfs(x,y):
  global res
  if dp[x][y]!=-1:
    return dp[x][y]
  tmp=-1
  for i in range(4):
    nx=x+dx[i]
    ny=y+dy[i]
    if 0<=nx<n and 0<=ny<n:
      if tree[x][y]<tree[nx][ny]:
        tmp=max(dfs(nx,ny),tmp)

  if tmp==-1:
    dp[x][y]=1
    return 1
  dp[x][y]=tmp+1
  res=max(res,dp[x][y])
  return dp[x][y]

dx=[0,0,-1,1]
dy=[-1,1,0,0]
n=int(input())
tree=[]
dp=[[-1]*n for i in range(n)]
for i in range(n):
  tree.append(list(map(int,input().split())))
res=1
for i in range(n):
  for j in range(n):
    if dp[i][j] == -1:
      dfs(i, j)
print(res)