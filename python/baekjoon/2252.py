from collections import deque
n,m=map(int,input().split())
visited=[0]*(n+1)
arr=[0]*(n+1)
adj=[[] for i in range(n+1)]
for i in range(m):
  a,b=map(int,input().split())
  adj[a].append(b)
  arr[b]+=1;
q=deque()
for i in range(1,n+1):
  if arr[i]==0:
    q.append(i)
    visited[i]=1
while q:
  x=q.popleft()
  print(x,end=' ')
  for i in adj[x]:
    arr[i]-=1
    if arr[i]==0 and visited[i]==0:
      q.append(i)
      visited[i]=1