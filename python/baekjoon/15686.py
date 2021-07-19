from collections import deque
import sys
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def bfs():
  q2=deque(q)
  ans=0
  while q2:
    x,y,cnt=q2.popleft()
    if arr[x][y]==1:
      ans+=cnt
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]
      if 0<=nx<n and 0<=ny<n:
        if visited[nx][ny]==0:
          visited[nx][ny]=1
          q2.append([nx,ny,cnt+1])
  return ans

def add(x,cnt):
  global res
  if cnt==m:
    for i in range(n):
      for j in range(n):
        visited[i][j]=dp[i][j]
    res=min(bfs(),res)
  for i in range(x,len(c)):
    q.append([c[i][0],c[i][1],0])
    dp[c[i][0]][c[i][1]]=1
    add(i+1,cnt+1)
    q.pop()
    dp[c[i][0]][c[i][1]]=0

n,m=map(int,input().split())
arr=[]
for i in range(n):
  arr.append(list(map(int,input().split())))
c=[]
res=3000
for i in range(n):
  for j in range(n):
    if arr[i][j]==2:
      c.append([i,j])
q=deque()
dp=[[0]*n for i in range(n)]
visited=[[0]*n for i in range(n)]

for i in range(len(c)-m+1):
  q.append([c[i][0],c[i][1],0])
  add(i+1,1)
  q.pop()

print(res)