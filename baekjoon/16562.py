import sys
input=sys.stdin.readline
def find(x):
    if p[x]==x:return x
    p[x]=find(p[x])
    return p[x]
def merge(x,y):
    x=find(x)
    y=find(y)
    if x==y: return
    if x>y:
        x,y=y,x
    p[y]=x

n,m,k=map(int,input().split())
p=[i for i in range(n+1)]
cost=[0]+list(map(int,input().split()))
res=[10000001]*(n+1)
for i in range(m):
    a,b=map(int,input().split())
    merge(a,b)
for i in range(1,n+1):
    tmp=find(i)
    res[tmp]=min(res[tmp],cost[i])
ans=0
for i in res:
    if i!=10000001:
        ans+=i
if ans>k:
    print('Oh no')
else:
    print(ans)