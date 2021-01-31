t=int(input())
for k in range(t):
    n,m=map(int,input().split())
    l=min(n,m)
    tmp=0
    for i in range(1,l+1):
        if n%i==0 and m%i==0:
            tmp=max(tmp,i)
    print((n//tmp)*(m//tmp)*tmp)