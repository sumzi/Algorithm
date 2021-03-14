import heapq
import sys
input=sys.stdin.readline
INF=sys.maxsize

t=int(input())
while t>0:
    n,m,k=map(int,input().split())
    arr=[[] for i in range(n+1)]
    for i in range(k):
        u,v,c,d=map(int,input().split())
        arr[u].append([v,c,d])
    dp=[[INF]*(m+1) for i in range(n+1)]
    dp[1][0]=0
    for i in range(m+1):
        for j in range(1,n+1):
            if dp[j][i]==INF:
                continue
            for nx,ncost,ntime in arr[j]:
                if i+ncost<=m:
                    dp[nx][i+ncost]=min(dp[nx][i+ncost],dp[j][i]+ntime)
    res=min(dp[n])
    print('Poor KCM' if res==INF else res)
    t-=1