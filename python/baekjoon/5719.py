import heapq
from collections import deque
import sys
input=sys.stdin.readline
INF=sys.maxsize
def dijkstra(num):
    q=[[0,num]]
    dp=[INF]*n
    dp[num]=0
    while q:
        cur,x=heapq.heappop(q)
        if cur>dp[x]:
            continue
        for nx,ncur in arr[x]:
            if ncur==-1:
                continue
            tmp=cur+ncur
            if tmp<dp[nx]:
                dp[nx]=tmp
                heapq.heappush(q,[tmp,nx])
                dist[nx]=[]
                dist[nx].append(x)
            elif tmp==dp[nx]:
                dist[nx].append(x)
    return dp

while True:
    n,m=map(int,input().split())
    if n==0 and m==0:
        break
    s,d=map(int,input().split())
    arr=[[] for i in range(n)]
    dist=[[] for i in range(n)]
    for i in range(m):
        a,b,c=map(int,input().split())
        arr[a].append([b,c])
    dijkstra(s)
    qq=deque([d])
    visited=[0]*n
    visited[d]=1
    while qq:
        x=qq.pop()
        for nx in dist[x]:
            for i in range(len(arr[nx])):
                if arr[nx][i][0]==x:
                    arr[nx][i][1]=-1
            if visited[nx]==0:
                qq.append(nx)
                visited[nx]=1
    res=dijkstra(s)
    print(-1 if res[d]==INF else res[d])