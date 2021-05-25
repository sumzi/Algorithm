from collections import deque
import sys
input=sys.stdin.readline

dx=[-1,0,0,1]
dy=[0,-1,1,0]

def bfs(a,b):
    visited=[[-1]*n for i in range(n)]
    visited[a][b]=0
    q=deque([[a,b]])
    eat=[]
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and visited[nx][ny]==-1:
                if loc[nx][ny]<=shark:
                    q.append([nx,ny])
                    visited[nx][ny]=visited[x][y]+1
                    if 0<loc[nx][ny]<shark:
                        eat.append([nx,ny,visited[nx][ny]])
    if not eat:
        return -1,-1,-1
    eat.sort(key=lambda x:(x[2],x[0],x[1]))
    return eat[0][0],eat[0][1],eat[0][2]

n=int(input())
loc=[]
start=[]
for i in range(n):
    loc.append(list(map(int,input().split())))
    for j in range(n):
        if loc[i][j]==9:
            start=[i,j]
            loc[i][j]=0
shark=2
baby=2
time=0
while 1:
    x,y=start
    a,b,c=bfs(x,y)
    if a==-1: break
    start=[a,b]
    loc[a][b]=0
    baby-=1
    if baby==0:
        shark+=1
        baby=shark
    time+=c
print(time)