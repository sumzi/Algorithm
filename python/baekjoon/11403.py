import sys
input=sys.stdin.readline
INF=sys.maxsize
n=int(input())
adj=[]
for i in range(n):
    adj.append(list(map(int,input().split())))
    for j in range(n):
        if adj[i][j]==0:
            adj[i][j]=INF
for i in range(n):
    for j in range(n):
        for k in range(n):
            adj[j][k]=min(adj[j][k],adj[i][k]+adj[j][i])
for i in adj:
    for j in i:
        print(0 if j==INF else 1,end=' ')
    print()