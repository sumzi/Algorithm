from collections import deque
import sys
input=sys.stdin.readline

t=int(input())
while t>0:
    h,w=map(int,input().split())
    arr=[]
    visited=[[0]*(103) for i in range(103)]
    key=[0]*26
    arr.append(['.']*(w+2))
    for i in range(h):
        arr.append(['.']+list(input().strip())+['.'])
    arr.append(['.']*(w+2))
    k=input().strip()
    if k!='0':
        for i in k:
            key[ord(i)-ord('a')]=1
    res=0
    q=deque([[0,0]])
    dx=[0,0,-1,1]
    dy=[-1,1,0,0]
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<h+2 and 0<=ny<w+2:
                if visited[nx][ny]==0:
                    if arr[nx][ny]=='*':
                        continue
                    if arr[nx][ny]=='$':
                        res+=1
                        arr[nx][ny]='.'
                    elif 'a'<=arr[nx][ny]<='z':
                        tmp=ord(arr[nx][ny])-ord('a')
                        if key[tmp]==0:
                            key[tmp]=1
                            arr[nx][ny]='.'
                            visited=[[0]*(103) for i in range(103)]
                    elif 'A'<=arr[nx][ny]<='Z':
                        tmp=ord(arr[nx][ny])-ord('A')
                        if key[tmp]==0:
                            visited[nx][ny]=1
                            continue
                    visited[nx][ny]=1
                    q.append([nx,ny])
    print(res)
    t-=1