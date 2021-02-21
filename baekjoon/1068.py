import sys
input=sys.stdin.readline
def dfs(cur):
    if visited[cur]==1:
        return 0
    res=0
    visited[cur]=1
    for i in dp[cur]:
        if visited[i]==0:
            res+=dfs(i)
    return 1 if res==0 else res

n=int(input())
arr=list(map(int,input().split()))
r=-1
visited=[0]*n
dp=[[] for i in range(n)]
for i in range(n):
    if arr[i]==-1:
        r=i    
    else:
        dp[arr[i]].append(i)
        dp[i].append(arr[i])
m=int(input())
visited[m]=1
print(dfs(r))