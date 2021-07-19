import heapq
import sys
input=sys.stdin.readline
INF=sys.maxsize

n,m=map(int,input().split())
arr=[[] for i in range(n+1)]
for i in range(m):
    a,b,c=map(int,input().split())
    arr[a].append([b,c])
    arr[b].append([a,c])
dp=[INF]*(n+1)
dp[1]=0
q=[[0,1]]
p={}
while q:
    cur,x=heapq.heappop(q)
    if cur>dp[x]:
        continue
    for nx,ncur in arr[x]:
        tmp=cur+ncur
        if tmp<dp[nx]:
            dp[nx]=tmp
            heapq.heappush(q,[tmp,nx])
            p[nx]=x
print(n-1)
for i in p:
    print(i,p[i])