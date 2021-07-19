n=int(input())
a=[]
for i in range(n):
    tmp=list(map(int,input().split()))
    a.append(tmp)

a.sort()
for i in range(n):
    print(a[i][0],a[i][1])