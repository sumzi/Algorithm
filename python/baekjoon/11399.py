n=int(input())
a=list(map(int,input().split()))

a.sort()
res=tmp=0
for i in a:
    tmp+=i
    res+=tmp

print(res)