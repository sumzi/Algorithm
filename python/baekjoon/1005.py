from collections import deque
import sys
input=sys.stdin.readline
t=int(input())
while t>0:
  n,k=map(int,input().split())
  time=[0]+list(map(int,input().split()))
  adj=[[] for i in range(n+1)]
  indegree=[0]*(n+1)
  res=[-1]*(n+1)

  for i in range(k):
    a,b=map(int,input().split())
    adj[a].append(b)
    indegree[b]+=1
  q=deque()
  for i in range(1,n+1):
    res[i]=time[i]
    if indegree[i]==0:
      q.append(i)
  while q:
    x=q.popleft()
    for nx in adj[x]:
      res[nx]=max(res[nx],res[x]+time[nx])
      indegree[nx]-=1
      if indegree[nx]==0:
        q.append(nx)
  print(res[int(input())])
  t-=1