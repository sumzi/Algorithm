import sys
sys.setrecursionlimit(10**6)
input=sys.stdin.readline
def dfs(x):
    visited[x]=1
    s=w=0
    if t[x][0]=='S':
        s=t[x][1]
    elif t[x][0]=='W':
        w=t[x][1]
    tmp=0
    for i in dp[x]:
        if visited[i]==0:
            tmp+=dfs(i)
    tmp+=s
    tmp-=w
    return 0 if tmp<0 else tmp
n=int(input())
t=[[],['',0]]
dp=[[] for i in range(n+1)]
visited=[0]*(n+1)
for i in range(2,n+1):
    tmp=list(input().split())
    dp[i].append(int(tmp[2]))
    dp[int(tmp[2])].append(i)
    t.append([tmp[0],int(tmp[1])])
print(dfs(1))