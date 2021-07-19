import sys
input=sys.stdin.readline
def init(l,r,node):
  if l==r:
    minN[node]=l
    maxN[node]=l
    return minN[node],maxN[node]
  mid=(l+r)//2
  a1,a2=init(l,mid,node*2)
  b1,b2=init(mid+1,r,node*2+1)
  minN[node]=min(a1,b1)
  maxN[node]=max(a2,b2)
  return minN[node],maxN[node]

def query(l,r,node,nodeL,nodeR):
  if r<nodeL or nodeR<l: 
    return True
  if nodeL<=l and r<=nodeR:
    return nodeL<=minN[node] and maxN[node]<=nodeR
  else:
    mid=(l+r)//2
    return query(l,mid,node*2,nodeL,nodeR) and query(mid+1,r,node*2+1,nodeL,nodeR)

def update(l,r,node,x,ans):
  if x<l or r<x:
    return minN[node],maxN[node]
  if l==r:
    minN[node]=ans
    maxN[node]=ans
  else:
    mid=(l+r)//2
    a1,a2=update(l,mid,node*2,x,ans)
    b1,b2=update(mid+1,r,node*2+1,x,ans)
    minN[node]=min(a1,b1)
    maxN[node]=max(a2,b2)
  return minN[node],maxN[node]

t=int(input())
while t>0:
  n,m=map(int,input().split())
  arr=[i for i in range(n)]
  minN=[0]*100001*4
  maxN=[0]*100001*4
  init(0,n-1,1)
  for i in range(m):
    a,b,c=map(int,input().split())
    x=arr[b]
    y=arr[c]
    if a==0:
      update(0,n-1,1,b,y)
      update(0,n-1,1,c,x)
      arr[b]=y
      arr[c]=x
    else:
      print('YES' if query(0,n-1,1,b,c) else 'NO')
  t-=1