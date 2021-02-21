from collections import deque
import sys
input=sys.stdin.readline
def bfs(cur):
    q=deque([cur])
    visited[cur]=1
    x=y=0    
    while q:
        a=q.popleft()
        x+=1
        for i in dp[a]:
            if visited[i]==0:
                q.append(i)
                visited[i]=1
            y+=1
    return 1 if (x-1)==(y//2) else 0

cnt=0
while True:
    cnt+=1
    res=0
    n,m=map(int,input().split())
    if n==0 and m==0:
        break
    dp=[[] for i in range(n+1)]
    visited=[0]*(n+1)
    for i in range(m):
        a,b=map(int,input().split())
        dp[a].append(b)
        dp[b].append(a)
    for i in range(1,n+1):
        if visited[i]==0:
            res+=bfs(i)

    if res==0:
        print('Case %d: No trees.'%cnt)
    elif res==1:
        print('Case %d: There is one tree.'%cnt)
    else:
        print('Case %d: A forest of %d trees.' %(cnt,res))