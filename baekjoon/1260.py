def dfs(x):
    visited[x]=1
    print(x,end=' ')
    for i in range(1,n+1):
        if arr[x][i]==1 and visited[i]==0:
            dfs(i)

def bfs(x):
    q=[x]
    visited[x]=0
    while q:
        y=q.pop(0)
        print(y,end=' ')
        for i in range(1,n+1):
            if arr[y][i]==1 and visited[i]==1:
                q.append(i)
                visited[i]=0

n,m,v=map(int,input().split())
arr=[[0]*(n+1) for i in range(n+1)]
visited=[0]*(n+1)
for i in range(m):
    a,b=map(int,input().split())
    arr[a][b]=arr[b][a]=1

dfs(v)
print()
bfs(v)