from collections import deque
import sys
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def bfs():
  global res
  q=deque()
  cnt=0
  dp2=[[0]*m for i in range(n)]
  for i in range(n):
    for j in range(m):
      dp2[i][j]=dp[i][j]
      if dp2[i][j]==2:
        q.append([i,j])
  while q:
    x,y=q.popleft()
    cnt+=1
    for i in range(4):
      nx=dx[i]+x
      ny=dy[i]+y
      if 0<=nx<n and 0<=ny<m:
        if dp2[nx][ny]==0:
          q.append([nx,ny])
          dp2[nx][ny]=2
  num=0
  for i in range(n):
    for j in range(m):
      if dp2[i][j]==0:
        num+=1
  res=max(res,num)

def wall(cnt):
  if cnt==3:
    bfs()
    return
  for i in range(n):
    for j in range(m):
      if dp[i][j]==0:
        dp[i][j]=1
        wall(cnt+1)
        dp[i][j]=0

n,m=map(int,input().split())
lab=[]
dp=[[0]*m for i in range(n)]
for i in range(n):
  lab.append(list(map(int,input().split())))
tmp=[]
res=0
for i in range(n):
  for j in range(m):
    if lab[i][j]==0:
      for a in range(n):
        for b in range(m):
          dp[a][b]=lab[a][b]
      dp[i][j]=1
      wall(1)
print(res)