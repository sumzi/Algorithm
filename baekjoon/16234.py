from collections import deque
import sys
input=sys.stdin.readline
dx=[-1,1,0,0]
dy=[0,0,-1,1]
tmp=deque()
def bfs(a,b,c):
    cnt=1
    num=arr[a][b]
    q=deque([[a,b]])
    visited[a][b]=c

    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and visited[nx][ny]==0:
                if l<=abs(arr[x][y]-arr[nx][ny])<=r:
                    visited[nx][ny]=c
                    cnt+=1
                    num+=arr[nx][ny]
                    q.append([nx,ny])

    if cnt>1:
        tmp.append([a,b,num//cnt,c])


n,l,r=map(int,input().split())
arr=[]
ans=0
for i in range(n):
    arr.append(list(map(int,input().split())))
visited=[[0]*n for _ in range(n)]

while 1:
    num=1
    for i in range(n):
        for j in range(n):
            if visited[i][j]==0:
                bfs(i,j,num)
                num+=1

    if len(tmp)==0:
        break
    while tmp:
        a,b,c,d=tmp.popleft()
        visited[a][b]=0
        arr[a][b]=c
        q2=deque([[a,b]])
        while q2:
            x,y=q2.popleft()
            for i in range(4):
                nx=x+dx[i]
                ny=y+dy[i]
                if 0<=nx<n and 0<=ny<n and visited[nx][ny]==d:
                    visited[nx][ny]=0
                    arr[nx][ny]=c
                    q2.append([nx,ny])           
    ans+=1
    visited=[[0]*n for _ in range(n)]
print(ans)