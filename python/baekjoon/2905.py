import sys
input=sys.stdin.readline
n,m=map(int,input().split())
tree=list(map(int,input().split()))
start=0
end=1000000000
while start+1<end:
  ans=0
  mid=(start+end)//2
  for i in tree:
    ans+=(i-mid if i>mid else 0)
  if ans>=m:
    start=mid
  else:
    end=mid
print(start)