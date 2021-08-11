import sys
input=sys.stdin.readline
from collections import deque
def bfs():
    visited=[[0]*m for i in range(n)]
    q=deque([[0,0]])
    cnt=0
    visited[0][0]=1
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<m and visited[nx][ny]==0:
                visited[nx][ny]=1
                if arr[nx][ny]==0:
                    q.append([nx,ny])
                else:
                    cnt+=1
                    arr[nx][ny]=0
    return cnt

dx=[0,0,-1,1]
dy=[-1,1,0,0]
n,m=list(map(int,input().split()))
arr=[list(map(int,input().split())) for i in range(n)]
ans=[]
while 1:
    tmp=bfs()
    if tmp!=0:
        ans.append(tmp)
    else:
        break
print(len(ans))
print(ans[-1])