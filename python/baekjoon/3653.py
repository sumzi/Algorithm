import sys
input=sys.stdin.readline

def update(l,r,node,x,ans):
  if x<l or r<x:
    return
  dp[node]+=ans
  if l!=r:
    mid=(l+r)//2
    update(l,mid,node*2,x,ans)
    update(mid+1,r,node*2+1,x,ans)

def query(l,r,node,nodeL,nodeR):
  if r<nodeL or nodeR<l:
    return 0
  if nodeL<=l and r<=nodeR:
    return dp[node]
  mid=(l+r)//2
  return query(l,mid,node*2,nodeL,nodeR)+query(mid+1,r,node*2+1,nodeL,nodeR)

t=int(input())
while t>0:
  n,m=map(int,input().split())
  index=list(map(int,input().split()))
  arr=[0]*(n+1)
  dp=[0]*(n+m+10)*4
  for i in range(m+1,n+m+1):
    arr[i-m]=i
    update(1,n+m,1,i,1)
  cnt=m
  for i in index:
    print(query(1,n+m,1,1,arr[i]-1),end=' ')
    update(1,n+m,1,arr[i],-1)
    arr[i]=cnt
    update(1,n+m,1,cnt,1)
    cnt-=1
  print()
  t-=1