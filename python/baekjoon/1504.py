import heapq
import sys
input=sys.stdin.readline

def dijkstra(x):
    q=[]
    dist=[INF]*(n+1)
    dist[x]=0
    heapq.heappush(q,[0,x])
    while q:
        cur,x=heapq.heappop(q)
        if cur > dist[x]:
            continue
        for nx,ncur in dp[x]:
            tmp=cur+ncur
            if tmp<dist[nx]:
                dist[nx]=tmp
                heapq.heappush(q,[tmp,nx])
    return dist
INF=sys.maxsize
n,e=map(int,input().split())
dp=[[] for i in range(n+1)]
for i in range(e):
    a,b,c=map(int,input().split())
    dp[a].append([b,c])
    dp[b].append([a,c])
v1,v2=map(int,input().split())
start=dijkstra(1)
route1=dijkstra(v1)
route2=dijkstra(v2)
res=min(start[v1]+route1[v2]+route2[n],start[v2]+route2[v1]+route1[n])
print(res if res<INF else -1)