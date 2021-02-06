import sys 
from collections import deque
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def bfs():
    while q:
        tmp=q.popleft()
        x=tmp[0]
        y=tmp[1]
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<m and 0<=ny<n and arr[nx][ny]==0:
                q.append([nx,ny])
                arr[nx][ny]=arr[x][y]+1
    return arr[x][y]

n,m=map(int,input().split())
arr=[]
q=deque()
for i in range(m):
    arr.append(list(map(int,input().split())))
    for j in range(n):
        if arr[i][j]==1:
            q.append([i,j])
res=bfs()-1
flag=False
for i in arr:
    for j in i:
        if j==0:
            flag=True
if flag==True:
    print(-1)
else:
    print(res)