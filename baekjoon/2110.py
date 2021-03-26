def check(x):
  print(x,end=' ')
  cnt=1
  ans=ip[0]
  for i in ip:
    if i>(ans+x-1):
      ans=i
      cnt+=1
  print(cnt)
  return cnt >= c
n,c=map(int,input().split())
ip=[]
for i in range(n):
  ip.append(int(input()))
ip.sort()
start=ip[0]
end=ip[-1]
res=0
while start<=end:
  mid=(start+end)//2
  if check(mid):
    res=mid
    start=mid+1
  else:
    end=mid-1
print(res)