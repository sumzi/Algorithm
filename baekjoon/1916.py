import sys
import heapq
input=sys.stdin.readline
n=int(input())
m=int(input())
dp=[[] for i in range(n+1)]
dist=[10**9]*(n+1)
for i in range(m):
    a,b,c=map(int,input().split())
    dp[a].append([b,c])
start,end=map(int,input().split())
q=[]
heapq.heappush(q,[0,start])
while q:
    curValue,x=heapq.heappop(q)
    if curValue>dist[x]:
        continue
    for nx,nextCurValue in dp[x]:
        tmp=curValue+nextCurValue
        if dist[nx]>tmp:
            dist[nx]=tmp
            heapq.heappush(q,[tmp,nx])
print(dist[end])