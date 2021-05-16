import sys
input=sys.stdin.readline

uf=[-1]*100001
def find(a):
    if uf[a]<0:
        return a
    uf[a]=find(uf[a])
    return uf[a]
def merge(a,b):
    if a>b:
        a,b=b,a
    a=find(a)
    b=find(b)
    if a==b:
        return False
    uf[b]=a
    return True    

n=int(input())
planet=[]
x=[]
y=[]
z=[]
dp=[]
for i in range(n):
    a,b,c=map(int,input().split())
    x.append([a,i])
    y.append([b,i])
    z.append([c,i])
x.sort()
y.sort()
z.sort()
for i in range(n-1):
    dp.append([x[i+1][0]-x[i][0],x[i][1],x[i+1][1]])
    dp.append([y[i+1][0]-y[i][0],y[i][1],y[i+1][1]])
    dp.append([z[i+1][0]-z[i][0],z[i][1],z[i+1][1]])
cnt=0
res=0
dp.sort()
for c,a,b in dp:
    if merge(a,b):
        cnt+=1
        res+=c
        if cnt==n-1:
            break
print(res)