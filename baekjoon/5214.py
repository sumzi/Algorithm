from collections import deque
import sys
input=sys.stdin.readline

n,k,m=map(int,input().split())
adj=[[] for i in range(n+m+1)]
visited=[0]*(n+m+1)
for i in range(n+1,n+m+1):
    st=list(map(int,input().split()))
    for j in st:
        adj[i].append(j)
        adj[j].append(i)
q=deque([[1,0]])
visited[1]=1
ans=-1
while q:
    x,y=q.popleft()
    if x==n:
        ans=y
        break
    for nx in adj[x]:
        if visited[nx]==0:
            visited[nx]=1
            q.append([nx,y+1])
if ans==-1:
    print(ans)
else:
    print(ans//2+1)