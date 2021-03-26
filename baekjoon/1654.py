def check(x):
  cnt=0
  for i in lan:
    if i>=x:
      cnt+=(i//x)
  return cnt>=n

k,n=map(int,input().split())
lan=[]
for i in range(k):
  lan.append(int(input()))
start=1
end=max(lan)
res=1
while start<=end:
  mid=(start+end)//2
  if check(mid):
    res=mid
    start=mid+1
  else:
    end=mid-1
print(res)