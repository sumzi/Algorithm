import sys
input=sys.stdin.readline

def init(l,r,node):
  if l==r:
    dp[node]=arr[l]
    return dp[node]
  mid=(l+r)//2
  dp[node]=init(l,mid,node*2)*init(mid+1,r,node*2+1)
  dp[node]%=1000000007
  return dp[node]

def update(l,r,node,num,x):
  if num<l or num>r:
    return
  if l==r:
    dp[node]=x
    return
  mid=(l+r)//2
  update(l,mid,node*2,num,x)
  update(mid+1,r,node*2+1,num,x)
  dp[node]=(dp[node*2]*dp[node*2+1])%1000000007
  
def multi(l,r,node,nodeL,nodeR):
  if r<nodeL or nodeR<l:
    return 1
  if nodeL<=l and r<=nodeR:
    return dp[node]

  mid=(l+r)//2
  tmp=(multi(l,mid,node*2,nodeL,nodeR)*multi(mid+1,r,node*2+1,nodeL,nodeR))%1000000007
  return tmp

n,m,k=map(int,input().split())
arr=[]
dp=[0]*10000000

for i in range(n):
  arr.append(int(input()))
init(0,n-1,1)
for i in range(m+k):
  a,b,c=map(int,input().split())
  if a==1:
    arr[b-1]=c
    update(0,n-1,1,b-1,c)
  else:
    print(multi(0,n-1,1,b-1,c-1))