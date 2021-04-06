import sys
input=sys.stdin.readline

def init(node,l,r):
  if l==r:
    dp[node]=arr[l]
    return dp[node]
  mid=(l+r)//2
  dp[node]=init(node*2,l,mid)+init(node*2+1,mid+1,r)
  return dp[node]

def segSum(l,r,node,nodeL,nodeR):
  if nodeR<l or nodeL>r:                                            
    return 0
  if nodeL>=l and r>=nodeR:
    return dp[node]
  mid=(nodeL+nodeR)//2
  return segSum(l,r,node*2,nodeL,mid)+segSum(l,r,node*2+1,mid+1,nodeR)

def update(node,l,r,x,ans):
  if x<l or r<x:
    return 
  dp[node]+=ans
  if l!=r:
    mid=(l+r)//2
    update(node*2,l,mid,x,ans)
    update(node*2+1,mid+1,r,x,ans)

n,m,k=map(int,input().split())
arr=[]
dp=[0]*10000000
for i in range(n):
  arr.append(int(input()))
init(1,0,n-1)
for i in range(m+k):
  a,b,c=map(int,input().split())
  if a==1:
    tmp=c-arr[b-1]
    arr[b-1]=c
    update(1,0,n-1,b-1,tmp)
  else:
    print(segSum(b-1,c-1,1,0,n-1))