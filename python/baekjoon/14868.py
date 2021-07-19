from collections import deque
import sys
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]
def find(x):
    if p[x]==x:
        return x
    p[x]=find(p[x])
    return p[x]
def merge(x,y):
    x=find(x)
    y=find(y)
    if x==y:
        return 0
    if x>y:
        x,y=y,x
    p[y]=x
    return 1
def bfs1():
    global k
    while q1:
        x,y=q1.popleft()
        q2.append([x,y])
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<nx<=n and 0<ny<=n:
                if arr[nx][ny] and arr[x][y]!=arr[nx][ny]:
                    if merge(arr[x][y],arr[nx][ny]):
                        k-=1
def bfs2():
    global k
    while q2:
        x,y=q2.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<nx<=n and 0<ny<=n:
                if not arr[nx][ny]:
                    arr[nx][ny]=arr[x][y]
                    q1.append([nx,ny])
                elif arr[x][y]!=arr[nx][ny]:
                    if merge(arr[x][y],arr[nx][ny]):
                        k-=1
n,k=map(int,input().split())
arr=[[0]*(n+1) for i in range(n+1)]
p={}
q1=deque()
q2=deque()
for i in range(1,k+1):
    a,b=map(int,input().split())
    p[i]=i
    arr[a][b]=i
    q1.append([a,b])
res=0
while k>1:
    bfs1()
    if k==1:
        break
    bfs2()
    res+=1
print(res)