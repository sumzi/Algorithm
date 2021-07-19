import sys
input=sys.stdin.readline
INF=sys.maxsize
n,m=map(int,input().split())
dist=[INF]*(n+1)
adj=[[] for i in range(n+1)]
for i in range(m):
    a,b,c=map(int,input().split())
    adj[a].append([b,c])
dist[1]=0
cycle=False
for i in range(1,n+1):
    print('------------',i,'일때')
    for j in range(1,n+1):
        print(j,'일때')
        for nx,a in adj[j]:
            if dist[j]!=INF and dist[nx]>dist[j]+a:
                dist[nx]=dist[j]+a
                if i==n:
                    cycle=True
            print(dist)
if cycle:
    print(-1)
else:
    for i in range(2,n+1):
        print(dist[i] if dist[i]!=INF else -1)