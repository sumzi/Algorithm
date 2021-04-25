def dfs(x,adj,visited):
    visited[x]=1
    for nx in adj[x]:
        if visited[nx]==0:
            dfs(nx,adj,visited)
def solution(n, computers):
    answer = 0
    adj=[[] for i in range(n)]
    visited=[0]*(n)
    for i in range(n):
        for j in range(n):
            if i!=j and computers[i][j]==1:    
                adj[i].append(j)
    print(adj)
    for i in range(n):
        if visited[i]==0:
            dfs(i,adj,visited)
            answer+=1
    return answer