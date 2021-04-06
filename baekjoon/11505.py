import sys
input=sys.stdin.readline

def init(node,l,r):
  if l==r:
    dp[node]=arr[l]
    return dp[node]
  mid=(l+r)//2
  dp[node]=(init(node*2,l,mid)*init(node*2+1,mid+1,r))%1000000007
  return dp[node]

def mul(l,r,node,nodeL,nodeR):
  if r<nodeL or nodeR<l:
    return 1
  if l<=nodeL and nodeR<=r:
    return dp[node]
  mid=(nodeL+nodeR)//2
  return mul(l,r,node*2,nodeL,mid)*mul(l,r,node*2+1,mid+1,nodeR)

def update(node,l,r,num,x,y):
  if num<l or num>r:
    return
  if x==0:
    dp[node]=0
  else:
    dp[node]//=x
    dp[node]*=y
    dp[node]=dp[node]%1000000007
  if l!=r:
    mid=(l+r)//2
    update(node*2,l,mid,num,x,y)
    update(node*2+1,mid+1,r,num,x,y)

n,m,k=map(int,input().split())
arr=[]
dp=[0]*10000000
for i in range(n):
  arr.append(int(input()))
init(1,0,n-1)
for i in range(m+k):
  a,b,c=map(int,input().split())
  if a==1:
    tmp=arr[b-1]
    arr[b-1]=c
    update(1,0,n-1,b-1,tmp,c)
  else:
    print(mul(b-1,c-1,1,0,n-1))