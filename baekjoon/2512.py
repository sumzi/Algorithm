n=int(input())
cost=list(map(int,input().split()))
m=int(input())
start=0
end=max(cost)
res=0
while start<=end:
  ans=0
  mid=(start+end)//2
  for i in cost:
    ans+=(mid if i>mid else i)
  if m>=ans:
    res=mid
    start=mid+1
  else:
    end=mid-1
print(res)