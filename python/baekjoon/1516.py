from collections import deque
n=int(input())
adj=[[] for i in range(n+1)]
cost=[0]*(n+1)
res=[0]*(n+1)
dp=[0]*(n+1)
q=deque()
for i in range(1,n+1):
  tmp=list(map(int,input().split()))
  cost[i]=tmp[0]
  res[i]=tmp[0]
  for j in tmp[1:-1]:
    adj[j].append(i)
    dp[i]+=1
for i in range(1,n+1):
  if dp[i]==0:
    q.append(i)
while q:
  x=q.popleft()
  for nx in adj[x]:
    res[nx]=max(res[nx],res[x]+cost[nx])
    dp[nx]-=1
    if dp[nx]==0:
      q.append(nx)
for i in res[1:]:
  print(i)