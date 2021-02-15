a,p=map(int,input().split())
arr=[a]
b=0
while True:
    tmp=arr[-1]
    res=0
    while tmp>0:
        temp=(tmp%10)
        res+=(temp**p)
        tmp//=10
    if res not in arr:
        arr.append(res)
    elif res in arr:
        b=arr.index(res)
        break
print(b)