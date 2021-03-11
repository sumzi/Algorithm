import heapq
import sys
input=sys.stdin.readline
INF=sys.maxsize

n,m,f,s,t=map(int,input().split())
arr=[[] for i in range(n)]
for i in range(m):
    a,b,c=map(int,input().split())
    arr[a].append([b,c])
    arr[b].append([a,c])
for i in range(f):
    a,b=map(int,input().split())
    arr[a].append([b,0])
dp=[[INF,INF] for i in range(n)]
dp[s][0]=0
q=[[0,s,0]]
while q:
    #현재값,현재도시,비행기여부
    cur,x,isF=heapq.heappop(q)
    if cur>dp[x][isF]:
        continue
    for nx,ncur in arr[x]:
        tmp=cur+ncur
        if ncur==0 and isF==1:
            continue
        if ncur==0 and isF==0:
            if tmp<dp[nx][1]:
                dp[nx][1]=tmp
                heapq.heappush(q,[tmp,nx,1])
        else:
            if tmp<dp[nx][isF]:
                dp[nx][isF]=tmp
                heapq.heappush(q,[tmp,nx,isF])
print(min(dp[t]))