import sys
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]
def dfs(x,y,cnt):
  if cnt==4:
    return dp[x][y]
  tmp=0
  for i in range(4):
    nx=x+dx[i]
    ny=y+dy[i]
    if 0<=nx<n and 0<=ny<m:
      if visited[nx][ny]==0:
        visited[nx][ny]=1
        tmp=max(tmp,dfs(nx,ny,cnt+1))
        visited[nx][ny]=0
  return tmp+dp[x][y]
  
def check(x,y):
  tmp=0
  if 0<x and 0<y<m-1:
    tmp=max(tmp,dp[x-1][y]+dp[x][y-1]+dp[x][y+1])
  if x<n-1 and 0<y<m-1:
    tmp=max(tmp,dp[x+1][y]+dp[x][y-1]+dp[x][y+1])
  if 0<x<n-1 and 0<y:
    tmp=max(tmp,dp[x-1][y]+dp[x+1][y]+dp[x][y-1])
  if 0<x<n-1 and y<m-1:
    tmp=max(tmp,dp[x-1][y]+dp[x+1][y]+dp[x][y+1])
  return tmp+dp[x][y]

n,m=map(int,input().split())
dp=[]
res=0
visited=[[0]*m for i in range(n)]
for i in range(n):
  dp.append(list(map(int,input().split())))
for i in range(n):
  for j in range(m):
    visited[i][j]=1
    res=max(dfs(i,j,1),res)
    res=max(check(i,j),res)
    visited[i][j]=0
print(res)