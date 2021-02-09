from collections import deque
import sys
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def bfs():
    while q:
        tmp=q.popleft()
        if tmp[0]=='123456780':
            print(tmp[1])
            return
        temp=list(tmp[0])
        zero=tmp[0].index('0')
        x=zero//3
        y=zero%3
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<3 and 0<=ny<3:
                temp[zero],temp[nx*3+ny]=temp[nx*3+ny],temp[zero]
                b=''.join(temp)
                
                if b not in s:
                    s.add(b)
                    q.append([b,tmp[1]+1])
                temp[zero],temp[nx*3+ny]=temp[nx*3+ny],temp[zero]
    print(-1)
arr=[]
for i in range(3):
    arr+=(input().split())

a=''.join(arr)
s=set()
s.add(a)
q=deque()
q.append([a,0])
bfs()