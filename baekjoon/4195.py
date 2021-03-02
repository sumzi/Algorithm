import sys
input=sys.stdin.readline

def merge(x,y):
    x=find(x)
    y=find(y)
    if x==y:
        return p[x][1]
    if x>y:
        x,y=y,x
    p[x][1]+=p[y][1]
    p[y][0]=x
    return p[x][1]
    
def find(x):
    if p[x][0]==x:
       return x
    p[x][0]=find(p[x][0])
    return p[x][0]

t=int(input())
while t>0:
    f=int(input())
    p={}
    for i in range(f):
        a=list(input().split())
        for j in a:
            if j not in p:
                p[j]=[j,1]
        print(merge(a[0],a[1]))
    t-=1