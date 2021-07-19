n,k=map(int,input().split())
a=[x for x in range(1,n+1)]
tmp=0
b=[]
for i in range(n):
    tmp+=k-1
    tmp%=len(a)
    b.append(a.pop(tmp))
print("<",end='')
for i in b[0:n-1]:
    print("%d, " %i,end='')
print("%d>"%b[n-1])