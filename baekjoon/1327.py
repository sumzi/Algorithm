import sys
from collections import deque
input=sys.stdin.readline
n,k=map(int,input().split())
arr=list(input().split())
visited=set(''.join(arr))
q=deque([[''.join(arr),0]])
arr=''.join(sorted(arr))
flag=False
while q:
    x,y=q.popleft()
    if x==arr:
        flag=True
        print(y)        
        break
    for i in range(n-k+1):
        tmp=list(x[i:i+k])
        nx=x[:i]+"".join(reversed(tmp))+x[i+k:]
        if nx not in visited:
            visited.add(nx)
            q.append([nx,y+1])
if not flag:
    print(-1)