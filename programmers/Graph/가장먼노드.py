from collections import deque

def solution(n, edge):
    answer = 0
    adj=[[] for i in range(n+1)]
    visited=[0]*(n+1)
    for x,y in edge:
        adj[x].append(y)
        adj[y].append(x)
    q=deque()
    q.append(1)
    visited[1]=1
    while q:
        answer=len(q)
        for i in range(len(q)):
            x = q.popleft()
            for nx in adj[x]:
                if visited[nx]==0:
                    visited[nx]=1
                    q.append(nx)   
    return answer