import heapq
import sys
input=sys.stdin.readline
uf=[-1]*100001
def find(x):
    if uf[x]<0:
        return x
    uf[x]=find(uf[x])
    return uf[x]
def merge(x,y):
    if x>y:
        x,y=y,x
    x=find(x)
    y=find(y)
    if x==y: return False
    uf[y]=x
    return True
n,m=map(int,input().split())
dp=[]
for i in range(m):
    a,b,c=map(int,input().split())
    dp.append([c,a,b])
dp.sort()
cnt=0
res=0
for c,a,b in dp:
    if merge(a,b):
        cnt+=1   
        res+=c
        if cnt==n-2:
            break
print(res)