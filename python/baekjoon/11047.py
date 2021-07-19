import sys
input=sys.stdin.readline

n,k=map(int,input().split())
a=[]

for i in range(n):
    a.append(int(input()))

cnt=0
while n>0:
    n-=1
    cnt+=(k//a[n])
    k%=a[n]

print(cnt)
