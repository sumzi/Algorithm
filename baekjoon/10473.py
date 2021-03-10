import heapq
import sys
input=sys.stdin.readline
INF=sys.maxsize
def dijkstra(num):
    q=[[0,num]]
    dp=[INF]*(n+1)
    dp[num]=0
    while q:
        cur,x=heapq.heappop(q)
        if cur>dp[x]:
            continue
        for nx,ncur in arr[x]:
            if dist[x]<dist[nx]:
                tmp=cur+ncur
                if tmp<dp[nx]:
                    dp[nx]=tmp
                    heapq.heappush(q,[tmp,nx])
    return dp

n,m,d,e=map(int,input().split())
dist=[INF]+list(map(int,input().split()))
arr=[[] for i in range(n+1)]
for i in range(m):
    a,b,c=map(int,input().split())
    arr[a].append([b,c])
    arr[b].append([a,c])
res1=dijkstra(1)
res2=dijkstra(n)
ans=-INF
for i in range(2,n):
    if res1[i]!=INF and res2[i]!=INF:
        ans=max(ans,dist[i]*e-(res1[i]+res2[i])*d)
print(ans if ans!=-INF else 'Impossible')