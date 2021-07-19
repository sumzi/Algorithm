from collections import deque
import sys
input=sys.stdin.readline
INF=sys.maxsize
w,h=map(int,input().split())
visited=[[INF]*w for i in range(h)]
arr=[]
q=deque()
dx=[-1,0,1,0]
dy=[0,1,0,-1]
tmp=0
end=[]
for i in range(h):
    arr.append(list(input().rstrip()))
    for j in range(w):
        if arr[i][j]=='C':
            if tmp==0:
                tmp+=1
                for k in range(4):
                    q.append([0,k,i,j])
            else:
                end=[i,j]
while q:
    a,b,x,y=q.popleft()
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        na=a
        if b!=i:
            na+=1
        if 0<=nx<h and 0<=ny<w and arr[nx][ny]!='*':
            if visited[nx][ny]>=na:
                visited[nx][ny]=na
                q.append([na,i,nx,ny])
print(visited[end[0]][end[1]])