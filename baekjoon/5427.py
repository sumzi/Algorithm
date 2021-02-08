import sys
from collections import deque
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def bfs():
    fcnt=len(fire)
    scnt=len(sg)
    while sg:
        #   불 이동
        for i in range(fcnt):
            f=fire.popleft()
            fx=f[0]
            fy=f[1]
            for j in range(4):
                fnx=fx+dx[j]
                fny=fy+dy[j]
                if 0<=fnx<h and 0<=fny<w:
                    if arr[fnx][fny]=='.' or arr[fnx][fny]=='@':
                        fire.append([fnx,fny])
                        arr[fnx][fny]='*'
        fcnt=len(fire)
    
        #   상근이 이동
        for i in range(scnt):
            s=sg.popleft()
            x=s[0]
            y=s[1]
            num=s[2]
            for j in range(4):
                nx=x+dx[j]
                ny=y+dy[j]
                if 0<=nx<h and 0<=ny<w:
                    if arr[nx][ny]=='.':
                        sg.append([nx,ny,num+1])
                        arr[nx][ny]='@'
                else:
                    print(num+1)
                    return
        scnt=len(sg)

    print('IMPOSSIBLE')

t=int(input())
while t>0:
    w,h=map(int,input().split())
    arr=[]
    fire=deque()
    sg=deque()
    for i in range(h):
        arr.append(list(input().strip()))
    for i in range(h):
        for j in range(w):
            if arr[i][j]=='@':
                sg.append([i,j,0])
            elif arr[i][j]=='*':
                fire.append([i,j])
    bfs()

    t-=1