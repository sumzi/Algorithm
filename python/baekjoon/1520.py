import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)

def downhill(x,y):
  if x==m-1 and y==n-1:
    return 1
  if visited[x][y]!=-1:
    return visited[x][y]
  tmp=0
  for i in range(4):
    nx=x+dx[i]
    ny=y+dy[i]
    if 0<=nx<m and 0<=ny<n:
      if dp[x][y]>dp[nx][ny]:
        tmp+=downhill(nx,ny)
  visited[x][y]=tmp
  return tmp
m,n=map(int,input().split())
dp=[]
visited=[[-1]*n for i in range(m)]
for i in range(m):
  dp.append(list(map(int,input().split())))
dx=[1,-1,0,0]
dy=[0,0,-1,1]
print(downhill(0,0))