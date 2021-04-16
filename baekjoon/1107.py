import sys
input=sys.stdin.readline

def check(x):
  x=str(x)
  for i in x:
    if i in arr:
      return False
  return True

n=int(input())
m=int(input())
arr=list(input().strip())
res=abs(n-100) 
for i in range(1000001):
  if check(i):
    res=min(res,abs(i-n)+len(str(i)))
print(res)