import sys
input=sys.stdin.readline
uf=[-1]*200001
def find(x):
    if uf[x]<0:
        return x
    uf[x]=find(uf[x])
    return uf[x]
def merge(x,y):
    x=find(x)
    y=find(y)
    if x==y:
        return False
    uf[y]=x
    return True
while True:
    m,n=map(int,input().split())
    if m==0 and n==0: break
    res=0
    dp=[]
    for i in range(n):
        uf[i]=-1
        a,b,c=map(int,input().split())
        res+=c
        dp.append([c,a,b])
    dp.sort()
    cnt=0
    for c,a,b in dp:
        if merge(a,b):
            res-=c
            cnt+=1
            if cnt==m-1:
                break
    print(res)