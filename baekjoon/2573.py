from collections import deque
import sys
input=sys.stdin.readline
def bfs(x,y):
    q=deque([[x,y]])
    visited[x][y]=1
    while q:    
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<m:
                if visited[nx][ny]==0 and ice[nx][ny]!=0:
                    visited[nx][ny]=1
                    q.append([nx,ny])

n,m=map(int,input().split())
ice=[]
visited=[[0]*m for i in range(n)]
tmp=[[0]*m for i in range(n)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]    
for i in range(n):
    ice.append(list(map(int,input().split())))
year=0
while 1:
    cnt=0
    visited=[[0]*m for i in range(n)]
    tmp=[[0]*m for i in range(n)]
    for i in range(n):
        for j in range(m):
            if ice[i][j]!=0 and visited[i][j]==0:
                cnt+=1
                bfs(i,j)
    if cnt>1:
        print(year)
        break
    if cnt==0:
        print(0)
        break
    for i in range(n):
        for j in range(m):
            if ice[i][j]!=0:
                cnt=0
                for k in range(4):
                    nx=i+dx[k]
                    ny=j+dy[k]
                    if 0<=nx<n and 0<=ny<m and ice[nx][ny]==0:
                        cnt+=1
                tmp[i][j]=max(0,ice[i][j]-cnt)
    for i in range(n):
        for j in range(m):
            ice[i][j]=tmp[i][j]
    year+=1