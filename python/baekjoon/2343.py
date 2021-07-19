def check(mid):
  cnt=1
  ans=0
  for i in blu:
    if i>mid:
      return 0
    ans+=i
    if ans>mid:
      ans=i
      cnt+=1
  return m>=cnt

n,m=map(int,input().split())
blu=list(map(int,input().split()))
start=0
end=sum(blu)
res=0
while start<=end:
  mid=(start+end)//2
  if check(mid):
    res=mid
    end=mid-1
  else:
    start=mid+1
print(res)