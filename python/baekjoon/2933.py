import sys
from collections import deque
input=sys.stdin.readline

r,c=map(int,input().split())
m=[list(input().strip()) for i in range(r)]
n=int(input())
h=list(map(int,input().split()))
dx=[0,0,-1,1]
dy=[-1,1,0,0]
for i in range(n):
    if i%2==0:
        for j in range(c):
            if m[r-h[i]][j]=='x':
                m[r-h[i]][j]='.'
                break
    else:
        for j in range(c-1,-1,-1):
            if m[r-h[i]][j]=='x':
                m[r-h[i]][j]='.'
                break
    visited=[[0]*c for j in range(r)]
    cnt=0
    idx=[]
    for a in range(r-1,-1,-1):
        for b in range(c):
            if m[a][b]=='x' and visited[a][b]==0:       
                cnt+=1
                tmp=[]
                q=deque([[a,b]])
                tmp.append([a,b])
                visited[a][b]=cnt
                while q:
                    x,y=q.popleft()
                    for j in range(4):
                        nx=x+dx[j]
                        ny=y+dy[j]
                        if 0<=nx<r and 0<=ny<c:
                            if visited[nx][ny]==0 and m[nx][ny]=='x':
                                q.append([nx,ny])
                                tmp.append([nx,ny])
                                visited[nx][ny]=cnt
                idx.append(tmp)
    for j in range(cnt):
        num=r
        for a,b in idx[j]:
            for k in range(a,r+1):
                if k==r:
                    num=min(num,k-a-1)
                else:
                    if 0<visited[k][b] and visited[k][b]!=(j+1):
                        num=min(num,k-a-1)
        if num>0:
            for a,b in idx[j]:
                visited[a][b]=0
            for a,b in idx[j]:
                visited[a+num][b]=j+1
    for a in range(r):
        for b in range(c):
            if visited[a][b]==0:
                m[a][b]='.'
            else:
                m[a][b]='x'
for j in m:
    print(''.join(j))