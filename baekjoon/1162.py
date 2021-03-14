import heapq
import sys
input=sys.stdin.readline
INF=sys.maxsize

n,m,k=map(int,input().split())
arr=[[] for i in range(n+1)]
for i in range(m):
    a,b,c=map(int,input().split())
    arr[a].append([b,c])
    arr[b].append([a,c])
q=[[0,1,k]]
dp=[[INF]*(k+1) for i in range(n+1)]
dp[1][k]=0
while q:
    cur,x,cnt=heapq.heappop(q)
    if dp[x][cnt]<cur:
        continue
    for nx,ncur in arr[x]:
        tmp=cur+ncur
        if cnt>0:
            if cur<dp[nx][cnt-1]:
                dp[nx][cnt-1]=cur
                heapq.heappush(q,[cur,nx,cnt-1])
        if tmp<dp[nx][cnt]:
            dp[nx][cnt]=tmp
            heapq.heappush(q,[tmp,nx,cnt])
print(min(dp[n]))