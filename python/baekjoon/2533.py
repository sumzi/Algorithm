import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline

def dfs(prev,cur,check):
    if dp[cur][check]!=-1:
        return dp[cur][check]
    dp[cur][check]=check
    for i in arr[cur]:
        if prev!=i:
            if check:
                dp[cur][1]+=min(dfs(cur,i,0),dfs(cur,i,1))
            else:
                dp[cur][0]+=dfs(cur,i,1)
    print(dp)
    return dp[cur][check]

n=int(input())
arr=[[] for i in range(n+1)]
dp=[[-1,-1] for i in range(n+1)]
for i in range(n-1):
    a,b=map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)
print(min(dfs(0,1,0),dfs(0,1,1)))