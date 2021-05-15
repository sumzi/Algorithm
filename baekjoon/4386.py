import math
uf=[-1]*101
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
n=int(input())
dp=[[0]*n for i in range(n)]
arr=[]
for i in range(n):
    arr.append(list(map(float,input().split())))
dp=[]
for i in range(n):
    for j in range(i+1,n):
        if i!=j:
            tmp=round(math.sqrt((arr[i][1]-arr[j][1])**2+(arr[i][0]-arr[j][0])**2),2)
            dp.append([tmp,i,j])
dp.sort()
cnt=0
res=0
for c,a,b in dp:
    if merge(a,b):
        cnt+=1
        res+=c
        if cnt==n-1:
            break
print(res)