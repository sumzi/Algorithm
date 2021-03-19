def dic(a,z):
  if a==0 or z==0:
    return 1
  if dp[a][z]!=-1:
    return dp[a][z]
  dp[a][z]=dic(a-1,z)+dic(a,z-1)
  return dp[a][z]

def find(a,z,cnt):
  global ans,flag
  if a==0:
    for i in range(z):
      ans+='z'
    return
  if z==0:
    for i in range(a):
      ans+='a'
    return
  tmp=dic(a-1,z)
  if cnt<=tmp:
    ans+='a'
    find(a-1,z,cnt)
  elif cnt<=1000000000:
    ans+='z'
    find(a,z-1,cnt-tmp)
  else:
    flag=True

ans=''
flag=False
n,m,k=map(int,input().split())
dp=[[-1]*(101) for i in range(101)]
if k>dic(n,m):
  print(-1)
else:  
  find(n,m,k)
  if flag:
    print(-1)
  else:
    print(ans)