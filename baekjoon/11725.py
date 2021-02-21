import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline
def dfs(cur):
    for i in dp[cur]:
        if visited[i]==0:
            visited[i]=cur
            dfs(i)
n=int(input())
dp=[[] for i in range(n+1)]
visited=[0]*(n+1)
for i in range(n-1):
    a,b=map(int,input().split())
    dp[a].append(b)
    dp[b].append(a)
dfs(1)
for i in visited[2:]:
    print(i)