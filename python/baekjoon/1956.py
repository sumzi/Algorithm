import sys
input=sys.stdin.readline
INF=sys.maxsize
v,e=map(int,input().split())
dist=[[INF]*(v+1) for i in range(v+1)]
for i in range(e):
    a,b,c=map(int,input().split())
    dist[a][b]=c
for i in range(1,v+1):
    for j in range(1,v+1):
        for k in range(1,v+1):
            dist[i][j]=min(dist[i][j],dist[i][k]+dist[k][j])
ans=INF
for i in range(1,v+1):
    ans=min(ans,dist[i][i])
print(-1 if ans==INF else ans)