from collections import deque
import sys
input=sys.stdin.readline

m,n,h=map(int,input().split())
box=[[] for i in range(h)]
ans=0
q=deque()
for i in range(h):
    for j in range(n):
        box[i].append(list(map(int,input().split())))
        for k in range(m):
            if box[i][j][k]==1:
                q.append([i,j,k])
dx=[-1,1,0,0,0,0]
dy=[0,0,-1,1,0,0]
dz=[0,0,0,0,-1,1]

while q:
    cnt=len(q)
    flag=False
    for i in range(cnt):
        z,x,y=q.popleft()
        for j in range(6):
            nx=x+dx[j]
            ny=y+dy[j]
            nz=z+dz[j]
            if 0<=nx<n and 0<=ny<m and 0<=nz<h and box[nz][nx][ny]==0:
                box[nz][nx][ny]=1
                q.append([nz,nx,ny])
                flag=True
    if flag:
        ans+=1
check=False
for i in range(h):
    for j in range(n):
        for k in range(m):
            if box[i][j][k]==0:
                check=True
                break

if check:
    print(-1)
else:
    print(ans)