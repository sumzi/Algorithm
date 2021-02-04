import sys
input= sys.stdin.readline
dx=[-2,-1,-2,-1,1,2,1,2]
dy=[-1,-2,1,2,-2,-1,2,1]

def bfs(x,y,fx,fy):
    q=[[x,y]]
    arr[x][y]=1
    while q:
        tmp=q.pop(0);
        x=tmp[0]
        y=tmp[1]
        if x==fx and y==fy:
            return arr[x][y]
        for i in range(8):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and arr[nx][ny]==0:
                arr[nx][ny]=arr[x][y]+1
                q.append([nx,ny])

t=int(input())
while t>0:
    n=int(input())
    arr=[[0]*(n) for i in range(n)]
    a,b=map(int,input().split())
    c,d=map(int,input().split())
    print(bfs(a,b,c,d)-1)
    t-=1