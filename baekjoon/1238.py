import heapq
import sys
input=sys.stdin.readline
INF=sys.maxsize
n,m,x=map(int,input().split())
arr=[[] for i in range(n+1)]
for i in range(m):
    a,b,c=map(int,input().split())
    arr[a].append([b,c])
ans=[0]*(n+1)
for i in range(1,n+1):
    q=[]
    dp=[INF]*(n+1)
    dp[i]=0
    heapq.heappush(q,[0,i])
    while q:
        cur,a=heapq.heappop(q)
        if dp[a]<cur:
            continue
        for na,ncur in arr[a]:
            tmp=cur+ncur
            if tmp<dp[na]:
                dp[na]=tmp
                heapq.heappush(q,[tmp,na])
    if i==x:
        for i in range(1,n+1):
            if i!=x:
                ans[i]+=dp[i]
    else:
        ans[i]+=dp[x]
print(max(ans))