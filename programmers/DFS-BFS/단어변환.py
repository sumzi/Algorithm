from collections import deque
def check(a,b):
    n=len(a)
    cnt=0
    for i in range(n):
        if a[i]!=b[i]:
            cnt+=1
    return (True if cnt==1 else False)

def solution(begin, target, words):
    n=len(words)
    adj=[[] for i in range(n)]
    visited=[0]*n
    for i in range(n):
        for j in range(i+1,n):
            if check(words[i],words[j]):
                adj[i].append(j)
                adj[j].append(i)
    res=-1
    q=deque()
    for i in range(n):
        if words[i]==target:
            res=i
        if check(begin,words[i]):
            q.append(i)
            visited[i]=1
    if res==-1:
        return 0
    answer = 1
    while q:
        m=len(q)
        for i in range(m):
            x=q.popleft()
            if x==res:
                return answer
            for nx in adj[x]:
                if visited[nx]==0:
                    q.append(nx)
                    visited[nx]=1
        answer+=1