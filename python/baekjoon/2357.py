import sys
input=sys.stdin.readline

def minInit(l,r,node):
  if l==r:
    minDp[node]=arr[l]
    return minDp[node]
  mid=(l+r)//2
  minDp[node]=min(minInit(l,mid,node*2),minInit(mid+1,r,node*2+1))
  return minDp[node]

def maxInit(l,r,node):
  if l==r:
    maxDp[node]=arr[l]
    return maxDp[node]
  mid=(l+r)//2
  maxDp[node]=max(maxInit(l,mid,node*2),maxInit(mid+1,r,node*2+1))
  return maxDp[node]

def minNum(l,r,node,nodeL,nodeR):
  if nodeR<l or r<nodeL:
    return 1000000001
  if nodeL<=l and r<=nodeR:
    return minDp[node]
  mid=(l+r)//2
  return min(minNum(l,mid,node*2,nodeL,nodeR),minNum(mid+1,r,node*2+1,nodeL,nodeR))
n,m=map(int,input().split())

def maxNum(l,r,node,nodeL,nodeR):
  if nodeR<l or r<nodeL:
    return 0
  if nodeL<=l and r<=nodeR:
    return maxDp[node]
  mid=(l+r)//2
  return max(maxNum(l,mid,node*2,nodeL,nodeR),maxNum(mid+1,r,node*2+1,nodeL,nodeR))

arr=[]
for i in range(n):
  arr.append(int(input()))
minDp=[0]*1000000
maxDp=[0]*1000000
minInit(0,n-1,1)
maxInit(0,n-1,1)
for i in range(m):
  a,b=map(int,input().split())
  print(minNum(0,n-1,1,a-1,b-1),maxNum(0,n-1,1,a-1,b-1))