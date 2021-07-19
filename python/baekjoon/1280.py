import sys
input=sys.stdin.readline
MAXN=200001
MOD=1000000007

def update(l,r,node,x):
  if l<=x<=r:
    a[node]+=1
    b[node]+=x
    if l!=r:
      mid=(l+r)//2
      update(l,mid,node*2,x)
      update(mid+1,r,node*2+1,x)

def queryCnt(l,r,node,nodeL,nodeR):
  if r<nodeL or nodeR<l:
    return 0
  if nodeL<=l and r<=nodeR:
    return a[node]
  mid=(l+r)//2
  return queryCnt(l,mid,node*2,nodeL,nodeR)+queryCnt(mid+1,r,node*2+1,nodeL,nodeR)

def queryDist(l,r,node,nodeL,nodeR):
  if r<nodeL or nodeR<l:
    return 0
  if nodeL<=l and r<=nodeR:
    return b[node]
  mid=(l+r)//2
  return queryDist(l,mid,node*2,nodeL,nodeR)+queryDist(mid+1,r,node*2+1,nodeL,nodeR)

n=int(input())
a=[0]*MAXN*4
b=[0]*MAXN*4
res=1
for i in range(n):
  m=int(input())
  if(i==0):
    update(0,MAXN,1,m)
  else:
    tmp=(queryCnt(0,MAXN,1,0,m-1)*m-queryDist(0,MAXN,1,0,m-1))%MOD
    tmp+=(queryDist(0,MAXN,1,m+1,MAXN)-queryCnt(0,MAXN,1,m+1,MAXN)*m)%MOD
    update(0,MAXN,1,m)
    res=(res*tmp)%MOD
print(res)