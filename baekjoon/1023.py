def dic(pos,cnt,x):
  if pos==n:
    if cnt:
      return 1
    else:
      return 1 if x else 0
  if dp[x][pos][cnt]!=-1:
    return dp[x][pos][cnt]
  tmp=dic(pos+1,cnt+1,x)
  if cnt:
    tmp+=dic(pos+1,cnt-1,x)
  else:
    tmp+=dic(pos+1,cnt,1)
  dp[x][pos][cnt]=tmp
  return tmp
def trace(pos,cnt,x,num):
  if pos==n: return
  tmp=dic(pos+1,cnt+1,x)
  if num<tmp:
    print('(',end='')
    trace(pos+1,cnt+1,x,num)
  else:
    print(')',end='')
    if cnt:
      trace(pos+1,cnt-1,x,num-tmp)
    else:
      trace(pos+1,cnt,1,num-tmp)

n,k=map(int,input().split())
dp=[[[-1]*n for i in range(n)]for i in range(2)]
if dic(0,0,0)<=k:
  print(-1)
else:
  trace(0,0,0,k)