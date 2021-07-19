def dic(pos,cnt):
  if pos==n:
    return 0 if cnt else 1
  if dp[pos][cnt]!=-1:
    return dp[pos][cnt]
  tmp=dic(pos+1,cnt+1)
  if cnt:
    tmp+=dic(pos+1,cnt-1)
  dp[pos][cnt]=tmp
  return tmp
def trace(pos,cnt,num):
  if pos==n:
    return
  tmp=dic(pos+1,cnt+1)
  if num<dp[pos+1][cnt+1]:
    print('(',end='')
    trace(pos+1,cnt+1,num)
  else:
    print(')',end='')
    trace(pos+1,cnt-1,num-tmp)  

n,k=map(int,input().split())
dp=[[-1]*(n+1) for i in range(n+1)]
if dic(0,0) <= k :
  print(-1)
else:
  trace(0,0,k)