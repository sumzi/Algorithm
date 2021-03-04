from collections import deque
import sys
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]
r,c=map(int,input().split())
arr=[]
m=[[0]*c for i in range(r)]
swan=[]
q1=deque()
q2=deque()
p={}
res=0
def check():
    if find(m[swan[0][0]][swan[0][1]])==find(m[swan[1][0]][swan[1][1]]):
        print(res)
        exit()
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
    p[y]=x
    return 1
def bfs1(x,y):
    q=deque([[x,y]])
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<r and 0<=ny<c and m[nx][ny]==0:
                if arr[nx][ny]=='.':
                    m[nx][ny]=m[x][y]
                    q.append([nx,ny])
                elif arr[nx][ny]=='X':
                    if arr[x][y]!='*':
                        q2.append([x,y])
                        arr[x][y]='*'
def bfs2():
    global cnt
    num=len(q2)
    while q2:
        for i in range(num):
            x,y=q2.popleft()
            for j in range(4):
                nx=x+dx[j]
                ny=y+dy[j]
                if 0<=nx<r and 0<=ny<c and m[nx][ny]==0:
                    if arr[nx][ny]=='X':
                        arr[nx][ny]='*'
                        q1.append([nx,ny])
                        m[nx][ny]=m[x][y]
                    else:
                        if m[nx][ny] and m[x][y]!=m[nx][ny]:
                            if merge(m[x][y],m[nx][ny]):
                               check()
                               cnt-=1
def bfs3():
    global cnt
    while q1:
        x,y=q1.popleft()
        q2.append([x,y])
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<r and 0<=ny<c:
                if m[nx][ny] and m[x][y]!=m[nx][ny]:
                    if merge(m[x][y],m[nx][ny]):
                        check()
                        cnt-=1
cnt=0
for i in range(r):
    arr.append(list(input().strip()))
    for j in range(c):
        if arr[i][j]=='L':
            swan.append([i,j])
            arr[i][j]='.'
for i in range(r):
    for j in range(c):
        if m[i][j]==0 and (arr[i][j]=='.' or arr[i][j]=='L'):
            cnt+=1
            p[cnt]=cnt
            m[i][j]=cnt
            bfs1(i,j)
while cnt>1:
    res+=1
    bfs2()
    bfs3()
print(res)