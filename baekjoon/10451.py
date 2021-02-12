from collections import deque
import sys
input=sys.stdin.readline
def bfs(a):
    q=deque()
    q.append(a)
    visited[a]=a
    while q:
        x=q.popleft()
        nx=arr[x]
        if visited[nx]==a:
            return True
        elif visited[nx]==0:
            q.append(nx)
            visited[nx]=x
    return False

t=int(input())
while t>0:
    n=int(input())
    arr=[0]
    arr+=map(int,input().split())
    visited=[0]*(n+1)
    cnt=0
    for i in range(1,n+1):
        if visited[i]==0:
            if bfs(i):
                cnt+=1
    print(cnt)
    t-=1                                             