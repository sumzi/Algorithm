from collections import deque
import sys
input=sys.stdin.readline
INF=sys.maxsize

n=int(input())
arr=[]
d=[]
visited=[[[INF]*4 for i in range(n)] for i in range(n)]
for i in range(n):
    arr.append(list(input().rstrip()))
    for j in range(n):
        if arr[i][j]=='#':
            d.append([i,j])
arr[d[0][0]][d[0][1]]='.'
dx=[-1,0,1,0]
dy=[0,1,0,-1]
q=deque()
ans=INF
for i in range(4):
    visited[d[0][0]][d[0][1]][i]=0
    q.append([d[0][0],d[0][1],i,0])
while q:
    x,y,z,m=q.popleft()
    if arr[x][y]=='#':
        ans=min(ans,m)
    elif arr[x][y]=='!':
        m+=1
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and arr[nx][ny]!='*':
                if visited[nx][ny][i]>m:
                    if i==z:
                        visited[nx][ny][i]=m-1
                        q.append([nx,ny,i,m-1])
                    else:
                        visited[nx][ny][i]=m
                        q.append([nx,ny,i,m])
    elif arr[x][y]=='.':
        nx=x+dx[z]
        ny=y+dy[z]
        if 0<=nx<n and 0<=ny<n and arr[nx][ny]!='*':
            if visited[nx][ny][z]>m:
                visited[nx][ny][z]=m
                q.append([nx,ny,z,m])
print(ans)