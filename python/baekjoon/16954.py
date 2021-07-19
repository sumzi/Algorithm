from collections import deque
import sys
input=sys.stdin.readline

arr=deque()
tmp=-1
flag=True
for i in range(8):
    arr.append(list(input().rstrip()))
    if '#' in arr[i] and flag:
        tmp=i
        flag=False 
if tmp!=-1:
    tmp=8-tmp
q=deque()
q.append([7,0])
visited=[]
dx=[-1,-1,1,1,0,0,-1,1]
dy=[-1,1,-1,1,1,-1,0,0]
ans=0
for i in range(tmp):
    n=len(q)
    visited=[[0]*8 for _ in range(8)]
    for j in range(n):
        x,y=q.popleft()
        if arr[x][y]=='#':
            continue
        elif arr[x][y]=='.' and visited[x][y]==0:
            visited[x][y]=1
            q.append([x,y])
        for k in range(8):
            nx=x+dx[k]
            ny=y+dy[k]
            if 0<=nx<8 and 0<=ny<8 and visited[nx][ny]==0:
                if arr[nx][ny]=='.':
                    q.append([nx,ny])
                    visited[nx][ny]=1
    arr.appendleft(['.']*8)
    arr.pop()
if len(q)>0:
    ans=1
print(ans)