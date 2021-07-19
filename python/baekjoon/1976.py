import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**9)
def find(x):
    if p[x]==x:return x
    p[x]=find(p[x])
    return p[x]
def merge(x,y):
    x=find(x)
    y=find(y)
    if p[x]==p[y]: return 
    if x>y:
        x,y=y,x
    p[y]=x

n=int(input())
m=int(input())
arr=[]
p=[i for i in range(n)]
for i in range(n):
    arr.append(list(map(int,input().split())))
for i in range(n):
    for j in range(n):
        if arr[i][j]==1:
            merge(i,j)
tmp=list(map(int,input().split()))
res=find(tmp[0]-1)
for i in range(1,m):
    if res!=find(tmp[i]-1):
        print('NO')
        exit()
print('YES')