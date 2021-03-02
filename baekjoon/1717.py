import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**9)

def merge(x,y):
    x=find(x)
    y=find(y)
    if x==y: return
    if(x<y):p[y]=x
    else:p[x]=y
    
def find(x):
    if p[x]==x:return x
    p[x]=find(p[x])
    return p[x]

n,m=map(int,input().split())
p=[i for i in range(n+1)]
for i in range(m):
    c,a,b=map(int,input().split())
    if c==0:
        merge(a,b)
    else:
        if find(a)==find(b):
            print('YES')
        else:
            print('NO')