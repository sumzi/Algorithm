n=int(input())
b=list(map(int,input().split()))
a=[0]*1000001
a[1]=1
for i in range(2,10000001):
    for j in range(i+i,10000001,i):
        a[j]=1