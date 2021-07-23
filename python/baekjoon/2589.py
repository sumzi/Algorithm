from collections import deque
import sys
input=sys.stdin.readline

def bfs(x,y):
    global ans
    visited2=[[0]*m for _ in range(n)]
    visited2[x][y]=1
    q=deque([[x,y,0]])
    while q:
        a,b,c=q.popleft()
        for j in range(4):
            na=a+dx[j]
            nb=b+dy[j]
            if 0<=na<n and 0<=nb<m and visited2[na][nb]==0 and arr[na][nb]=='L':
                visited2[na][nb]=1
                q.append([na,nb,c+1])
        if len(q)==0:
            ans=max(ans,c)

n,m=map(int,input().split())
arr=[list(input().rstrip()) for i in range(n)]
visited=[[0]*m for i in range(n)]
dx=[0,0,-1,1]
dy=[-1,1,0,0]
ans=0
cnt=0
tmp=[]
for i in range(n):
    for j in range(m):
        if arr[i][j]=='L' and visited[i][j]==0:
            cnt+=1
            visited[i][j]=1
            q=deque([[i,j]])
            while q:
                x,y=q.popleft()
                flag=True
                for k in range(4):
                    nx=x+dx[k]
                    ny=y+dy[k]
                    if 0<=nx<n and 0<=ny<m and visited[nx][ny]==0 and arr[nx][ny]=='L':
                        visited[nx][ny]=1
                        flag=False
                        q.append([nx,ny])
                if flag:
                    tmp.append([x,y])
for i,j in tmp:
    bfs(i,j)
print(ans)