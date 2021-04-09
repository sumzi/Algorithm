import sys
input=sys.stdin.readline

def init(l,r,node):
  if l==r:
    dp[node]=1
    return dp[node]
  mid=(l+r)//2
  dp[node]=init(l,mid,node*2)+init(mid+1,r,node*2+1)
  return dp[node]

def change(l,r,node,nodeL,nodeR):
  if r<nodeL or nodeR<l:
    return 0
  if nodeL<=l and r<=nodeR:
    return dp[node]
  mid=(l+r)//2
  return change(l,mid,node*2,nodeL,nodeR)+change(mid+1,r,node*2+1,nodeL,nodeR)

def update(l,r,node,x):
  if x<l or r<x:
    return 
  dp[node]-=1
  if l!=r:
    mid=(l+r)//2
    update(l,mid,node*2,x)
    update(mid+1,r,node*2+1,x)

n=int(input())
arr=[]
dp=[0]*1000000
for i in range(n):
  m=int(input())
  arr.append([m,i])
arr.sort()
init(0,n-1,1)
for i in range(1,n//2+1):
  tmp=arr[i-1][1]
  print(change(0,n-1,1,0,tmp-1))
  update(0,n-1,1,tmp)
  tmp=arr[-i][1]
  print(change(0,n-1,1,tmp+1,n-1))
  update(0,n-1,1,tmp)
if n%2==1:
  print(0)