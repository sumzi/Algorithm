import sys
INF=sys.maxsize
n,m=map(int,input().split())
adj=[[INF]*(n+1) for i in range(n+1)]
for i in range(m):
    a,b=map(int,input().split())
    adj[a][b]=1
    adj[b][a]=1
for i in range(1,n+1):
    for j in range(1,n+1):
        for k in range(1,n+1):
            adj[j][k]=min(adj[j][k],adj[j][i]+adj[i][k])
ans=1
num=INF
for i in range(1,n+1):
    tmp=0
    for j in range(1,n+1):
        if i!=j and adj[i][j]!=INF:
            tmp+=adj[i][j]
    if tmp<num:
        ans=i
        num=tmp
print(ans)