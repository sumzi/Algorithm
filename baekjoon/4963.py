from collections import deque
import sys
input=sys.stdin.readline
dx=[0,0,-1,1,-1,-1,1,1]
dy=[-1,1,0,0,-1,1,-1,1]

def bfs(x,y):
    m[x][y]=0
    q=deque()
    q.append([x,y])
    while q:
        tmp=q.popleft()
        x=tmp[0]
        y=tmp[1]
        for i in range(8):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<h and 0<=ny<w and m[nx][ny]==1:
                m[nx][ny]=0
                q.append([nx,ny])

while True:
    w,h=map(int,input().split())
    if w==0 and h==0:
        break
    m=[]
    for i in range(h):
        m.append(list(map(int,input().split())))
    cnt=0
    for i in range(h):
        for j in range(w):
            if m[i][j]==1:
                bfs(i,j)
                cnt+=1
    print(cnt)