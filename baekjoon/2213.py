import sys
input=sys.stdin.readline
def dfs(prev,cur):
    dp[cur][1]=w[cur]
    for i in arr[cur]:
        if prev!=i:
            dfs(cur,i)
            dp[cur][0]+=max(dp[i][0],dp[i][1])
            dp[cur][1]+=dp[i][0]
def trace(prev,cur,isV):
    if isV:
        res.append(cur)
        for i in arr[cur]:
            if prev!=i:
                trace(cur,i,0)
    else:
        for i in arr[cur]:
            if prev!=i:
                if dp[i][0]<dp[i][1]:
                    trace(cur,i,1)
                else:
                    trace(cur,i,0)

res=[]
n=int(input())
w=[0]+list(map(int,input().split()))
arr=[[] for i in range(n+1)]
dp=[[0,0] for i in range(n+1)]
for i in range(n-1):
    a,b=map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)
dfs(0,1)
if dp[1][0]<dp[1][1]:
    trace(0,1,1)
else:
    trace(0,1,0)
print(max(dp[1]))
res.sort()
for i in res:
    print(i,end=' ')