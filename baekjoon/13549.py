import heapq

n,k=map(int,input().split())
q=[]
dp=[0]*1000001
dp[n]=1
heapq.heappush(q,[0,n])
while q:
  s,x=heapq.heappop(q)
  if x==k:
    print(s)
    break
  if x*2<1000001:
    if dp[x*2]==0:
      dp[x*2]=1
      heapq.heappush(q,[s,x*2])
  if x-1>-1:
    if dp[x-1]==0:
      dp[x-1]=1
      heapq.heappush(q,[s+1,x-1])
  if x+1<1000001:
    if dp[x+1]==0:
      dp[x+1]=1
      heapq.heappush(q,[s+1,x+1])