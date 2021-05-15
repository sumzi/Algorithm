uf=[-1]*1001

def find(x):
    if uf[x]<0: return x
    uf[x]=find(uf[x]) 
    return uf[x]

def merge(a,b):
    a=find(a)
    b=find(b)
    if a==b: return False
    uf[b]=a
    return True

n=int(input())
m=int(input())
dp=[]
for i in range(m):
    a,b,c=map(int,input().split())
    dp.append([c,a,b])
dp.sort()
v=0
res=0
for c,a,b in dp:
    if merge(a,b):
        v+=1
        res+=c
        if v==n-1:
            break
print(res)