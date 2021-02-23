import sys
input=sys.stdin.readline
def dfs(cur,isParent):
    if visited[cur]!=-1:
        return visited[cur]
    
    tmp=(1 if isParent==0 else 0)
    for i in dp[cur]:
        if isParent==1:
            tmp+=(min(dfs(i,1)+1,dfs(i,0)))
        elif isParent==0:
            tmp+=(dfs(i,1))    
    visited[cur]=tmp
    print(cur,"에서",visited)
    return tmp
n=int(input())
visited=[-1]*(n+1)
dp=[[] for i in range(n+1)]
for i in range(n-1):
    a,b=map(int,input().split())
    dp[a].append(b)
    dp[b].append(a)
print(dfs(1,1))
print(visited)
#print(min(dfs(0,1,1),dfs(0,1,0)))