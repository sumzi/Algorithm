n=int(input())
d=[5000]*(n+3)
d[3]=d[5]=1

for i in range(6,n+1):
    tmp=min(d[i-3],d[i-5])
    if tmp!=5000:
        d[i]=tmp+1

if d[n]!=5000:
    print(d[n])
else:
    print(-1)