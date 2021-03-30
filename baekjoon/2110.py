import sys
input=sys.stdin.readline
def check(x):
  cnt=1
  ans=ip[0]
  for i in ip[1:]:
    if ans+x<=i:
      ans=i
      cnt+=1
  return cnt >= c
n,c=map(int,input().split())
ip=[]
for i in range(n):
  ip.append(int(input()))
ip.sort()
start=1
end=ip[-1]-ip[0]
res=0
while start<=end:
  mid=(start+end)//2
  if check(mid):
    res=mid
    start=mid+1
  else:
    end=mid-1
print(res)