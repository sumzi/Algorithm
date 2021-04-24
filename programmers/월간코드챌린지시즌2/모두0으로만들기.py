from collections import deque
def solution(a, edges):
    n = len(a)
    adj=[[] for i in range(n)]
    dp = [0]*n
    visited = [0]*n
    for x,y in edges:
        adj[x].append(y)
        adj[y].append(x)
        dp[x]+=1
        dp[y]+=1
    q = deque()
    for i in range(n):
        if dp[i]==1:
            q.append(i)
    res = 0
    for i in range(n-1):
        x=q.popleft()
        visited[x]=1
        for nx in adj[x]:
            dp[nx]-=1
            if visited[nx]==0:
                res+=abs(a[x])
                a[nx]+=a[x]
                a[x]-=a[x]
            if dp[nx]==1 and visited[nx]==0:
                q.append(nx)
    if sum(a)==0:
        return res
    else:
        return -1
        
print(solution([-5,0,2,1,2],[[0,1],[3,4],[2,3],[0,3]]))     