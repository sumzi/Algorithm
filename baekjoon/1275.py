import sys
input=sys.stdin.readline

def init(l,r,node):
  if l==r:
    dp[node]=arr[l]
    return dp[node]
  mid=(l+r)//2
  dp[node]=init(l,mid,node*2)+init(mid+1,r,node*2+1)
  return dp[node]

def segSum(l,r,node,nodeL,nodeR):
  if r<nodeL or nodeR<l:
    return 0
  if nodeL<=l and r<=nodeR:
    return dp[node]

  mid=(l+r)//2
  return segSum(l,mid,node*2,nodeL,nodeR)+segSum(mid+1,r,node*2+1,nodeL,nodeR)

def update(l,r,node,x,ans):
  if r<x or x<l:
    return
  dp[node]+=ans
  if l!=r:
    mid=(l+r)//2
    update(l,mid,node*2,x,ans)
    update(mid+1,r,node*2+1,x,ans)

n,m=map(int,input().split())
arr=list(map(int,input().split()))
dp=[0]*1000000
init(0,n-1,1)
for i in range(m):
  x,y,a,b=map(int,input().split())
  if x>y:
    x,y=y,x
  print(segSum(0,n-1,1,x-1,y-1))
  tmp=b-arr[a-1]
  arr[a-1]=b
  update(0,n-1,1,a-1,tmp)