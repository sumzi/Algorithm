def seq(cur,pos,ans):
  if pos==n:
    if ans==m:
      return 1
    return 0
  if dp[cur][pos][ans]!=-1:
    return dp[cur][pos][ans]
  tmp=0
  for i in range(cur,m+1):
    if ans+i>m:
      continue
    tmp+=seq(i,pos+1,ans+i)
  dp[cur][pos][ans]=tmp
  return tmp

def trace(cur,pos,ans,num):
  if pos==n:
    return
  tmp=seq(cur,pos+1,ans+cur)
  if num<=tmp:
    print(cur,end=' ')
    trace(cur,pos+1,ans+cur,num)
  else:
    trace(cur+1,pos,ans,num-tmp)
n,m,k=map(int,input().split())
dp=[[[-1]*(m+1) for i in range(n)] for i in range(m+1)]
if seq(1,0,0)>=k:
  trace(1,0,0,k)