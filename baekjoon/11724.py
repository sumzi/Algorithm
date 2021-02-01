import sys
sys.setrecursionlimit(10000)
input= sys.stdin.readline
def dfs(x):
    visited[x]=1
    for i in range(1,n+1):
        if visited[i]==0 and arr[x][i]==1:
            dfs(i)

n,m=map(int,input().split())
arr=[[0]*(n+1) for i in range(n+1)]
visited=[0]*(n+1)
for i in range(m):
    a,b=map(int,input().split())
    arr[a][b]=arr[b][a]=1
cnt=0

for i in range(1,n+1):
    if not visited[i]:
        dfs(i)
        cnt+=1
print(cnt)