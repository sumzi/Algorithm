n=int(input())
b=list(map(int,input().split()))
a=[0]*1001
a[1]=1
for i in range(2,1001):
    for j in range(i+i,1001,i):
        a[j]=1
tmp=0
for i in b:
    if not a[i]:
        tmp+=1
print(tmp)        