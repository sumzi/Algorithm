from collections import deque
import sys
sys.setrecursionlimit(10000000)
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]
n=int(input())
arr=[list(map(int,input().split())) for i in range(n)]
visited=[[0]*n for i in range(n)]
cnt=1
ans=sys.maxsize

def dfs(x,y):
    global cnt
    arr[x][y]=cnt
    q[cnt].append([x,y])
    visited[x][y]=1
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<n and 0<=ny<n and visited[nx][ny]==0 and arr[nx][ny]:
            dfs(nx,ny)
def bfs(num):
    global ans
    dist=[[0]*n for i in range(n)]
    a=deque(q[num])
    while a:
        x,y=a.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if arr[nx][ny]>0 and arr[nx][ny]!=num:
                    ans=min(ans,dist[x][y])
                    return 
                if arr[nx][ny]==0 and dist[nx][ny]==0:
                    dist[nx][ny]=dist[x][y]+1
                    a.append([nx,ny])

q=[[]]
for i in range(n):
    for j in range(n):
        if arr[i][j] and visited[i][j]==0:
            q.append([])
            dfs(i,j)
            cnt+=1

for i in range(1,cnt):
    bfs(i)
print(ans)