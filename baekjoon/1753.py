import heapq
import sys
input=sys.stdin.readline
V,E=map(int,input().split())
dp=[[] for i in range(V+1)]
dist=[10000000]*(V+1)
K=int(input())
for i in range(E):
    u,v,w=map(int,input().split())
    dp[u].append([v,w])
dist[K]=0
q=[]
for i in dp[1:]:
    i.sort()
heapq.heappush(q,[0,K])
while q:
    cur,x=heapq.heappop(q)
    if dist[x]<cur:
        continue
    for nx,ncur in dp[x]:
        ncur+=cur
        if ncur<dist[nx]:
            dist[nx]=ncur
            heapq.heappush(q,[dist[nx],nx])
for i in dist[1:]:
    print(i if i!=10000000 else 'INF')