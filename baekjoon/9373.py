import heapq
import math
import sys
input=sys.stdin.readline
uf=[-1]*1003
def find(x):
    if uf[x]<0:
        return x
    uf[x]=find(uf[x])
    return uf[x]
def merge(a,b):
    if a>b:
        a,b=b,a
    a=find(a)
    b=find(b)
    if a==b:
        return False
    uf[b]=a
    return True

t=int(input())
while t>0:
    w=int(input()) 
    n=int(input()) 
    for i in range(n+2):
        uf[i]=-1
    sensor=[]
    q=[]
    q.append([w,n,n+1])
    for i in range(n):
        sensor.append(list(map(int,input().split())))
    for i in range(n):
        x,y,r=sensor[i]
        tmp=0 if x-r<0 else x-r
        heapq.heappush(q,[tmp,i,n])
        tmp=0 if w-x-r<0 else w-x-r
        heapq.heappush(q,[tmp,i,n+1])
        for j in range(i+1,n):
            x2,y2,r2=sensor[j]
            tmp=math.sqrt((x-x2)**2+(y-y2)**2)-r-r2
            if tmp<0:
                tmp=0
            heapq.heappush(q,[tmp,i,j])
    res=0
    while q:
        c,a,b=heapq.heappop(q)
        if merge(a,b):
            if find(n)==find(n+1):
                res=c/2
                break
    if res==0:
        print(0)
    else:
        print(round(res,6))
    t-=1