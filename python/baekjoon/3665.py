from collections import deque
import sys
input=sys.stdin.readline

t=int(input())
while t>0:
    n=int(input())
    adj=[[0]*(n+1) for i in range(n+1)]
    arr=list(map(int,input().split()))
    indegree=[0]*(n+1)
    for i in range(n-1):
        for j in range(i+1,n):
            adj[arr[i]][arr[j]]=1
            indegree[arr[j]]+=1
    res=[]        
    m=int(input())
    for i in range(m):
        a,b=map(int,input().split())
        if adj[a][b]:
            adj[a][b]=0
            adj[b][a]=1
            indegree[b]-=1
            indegree[a]+=1
        else:
            adj[a][b]=1
            adj[b][a]=0
            indegree[b]+=1
            indegree[a]-=1
    q=deque()
    flag=False
    for i in range(1,n+1):
        if indegree[i]==0:
            q.append(i)
    while q:
        if len(q)>1:
            flag=True
            break
        x=q.popleft()
        res.append(x)
        for nx in range(1,n+1):
            if adj[x][nx]:
                indegree[nx]-=1
                if indegree[nx]==0:
                    q.append(nx)
    if flag:
        print('?')
    elif len(res)==n:
        for i in res:
            print(i,end=' ')
        print()
    else:
        print('IMPOSSIBLE')
    t-=1