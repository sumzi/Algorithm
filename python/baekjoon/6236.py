def check(x):
  ans=x
  cnt=1
  for i in cost:
    if i>x:
      return 0
    if ans>=i:
      ans-=i
    else:
      ans=x-i
      cnt+=1
  return cnt<=m
n,m=map(int,input().split())
cost=[]
for i in range(n):
  cost.append(int(input()))
res=0
start=0
end=1000000000
while start<=end:
  mid=(start+end)//2
  if check(mid):
    res=mid
    end=mid-1
  else:
    start=mid+1
print(res)