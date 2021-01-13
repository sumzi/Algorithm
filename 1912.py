n=int(input())
a=list(map(int,input().split()))

sum=0
maxInt=-1001
for i in range(n):
    sum+=a[i]
    if a[i]>sum:
        sum=a[i]
    maxInt=max(sum,maxInt)

print(maxInt)