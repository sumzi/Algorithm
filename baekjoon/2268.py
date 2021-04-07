import sys
input=sys.stdin.readline
def segSum(l,r,node,nodeL,nodeR):
  if r<nodeL or nodeR<l:
    return 0
  if nodeL<=l and r<=nodeR:
    return dp[node]
  mid=(l+r)//2
  return segSum(l,mid,node*2,nodeL,nodeR)+segSum(mid+1,r,node*2+1,nodeL,nodeR)

def update(l,r,node,x,ans):
  if x<l or r<x:
    return 
  dp[node]+=ans
  if l!=r:
    mid=(l+r)//2
    update(l,mid,node*2,x,ans)
    update(mid+1,r,node*2+1,x,ans)

n,m=map(int,input().split())
arr=[0]*n
dp=[0]*10000000
for i in range(m):
  a,b,c=map(int,input().split())
  if a==0:
    if b>c:
      b,c=c,b
    print(segSum(0,n-1,1,b-1,c-1))
  else:
    tmp=c-arr[b-1]
    arr[b-1]=c
    update(0,n-1,1,b-1,tmp)