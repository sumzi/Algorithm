import sys
input=sys.stdin.readline
uf=[-1]*10001
def find(x):
    if uf[x]<0:
        return x
    uf[x]=find(uf[x])
    return uf[x]
def merge(x,y):
    x=find(x)
    y=find(y)
    if x==y: return False
    uf[y]=x
    return True
v,e=map(int,input().split())
dp=[]
for i in range(e):
    a,b,c = map(int,input().split())
    dp.append([c,a,b])
dp.sort()
res=0
cnt=0
for c,a,b in dp:
    if merge(a,b):
        cnt+=1
        res+=c
        if cnt==v-1:
            break
print(res)