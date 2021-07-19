import sys
input=sys.stdin.readline
def bfs():
    q=[a]
    visit[a]=1
    cnt=0
    tmp=1
    while q:
        for i in range(tmp):
            x=q.pop(0)
            if x==b:
                return cnt
            for j in arr[x]:
                if visit[j]==0:
                    q.append(j)
                    visit[j]=1
        tmp=len(q)
        cnt+=1
    return -1

n=int(input())
arr=[[] for i in range(n+1)]
visit=[0]*(n+1)
a,b=map(int,input().split())
m=int(input())
for i in range(m):
    c,d=map(int,input().split())
    arr[c].append(d)
    arr[d].append(c)

print(bfs())