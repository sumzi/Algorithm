import sys
from collections import deque
input=sys.stdin.readline

def bfs():
    q=deque()
    q.append([n,""])
    while q:
        a=q.popleft()
        x=a[0]
        y=a[1]
        if x==m:
            print(y)
            return
        nx=(x*2)%10000
        if arr[nx]==0:
            q.append([nx,y+'D'])
            arr[nx]=1
        nx=x-1 if x!=0 else 9999
        if arr[nx]==0:
            q.append([nx,y+'S'])
            arr[nx]=1
        nx=x%1000*10+x//1000
        if arr[nx]==0:
            q.append([nx,y+'L'])
            arr[nx]=1
        nx=x%10*1000+x//10
        if arr[nx]==0:
            q.append([nx,y+'R'])
            arr[nx]=1
        
t=int(input())
for i in range(t):
    n,m=map(int,input().split())
    arr=[0 for i in range(10000)]
    arr[n]=1
    bfs()