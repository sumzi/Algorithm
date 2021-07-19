import sys
from collections import deque
input=sys.stdin.readline
def bfs(x):
    q=deque()
    q.append(x)
    visited[x]=1
    while q:
        x=q.popleft()
        y=visited[x]
        for i in arr[x]:
            if visited[i]==y:
                return True
            elif visited[i]==0:
                q.append(i)
                visited[i]=2 if y==1 else 1
    return False

k=int(input())
while k>0:
    v,e=map(int,input().split())
    arr=[[] for i in range(v+1)]
    visited=[0]*(v+1)
    for i in range(e):
        a,b=map(int,input().split())
        arr[a].append(b)
        arr[b].append(a)
    flag=False
    for i in range(1,v+1):
        if visited[i]==0:
            if bfs(i):
                flag=True
    if flag:
        print("NO")
    else:
        print("YES")
    k-=1