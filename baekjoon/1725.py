def divide(first,last):
    if first==last:
        return a[first]
    mid=(first+last)//2
    res=max(divide(first,mid),divide(mid+1,last))
    l=mid
    r=mid+1
    cntRes=2
    minRes=min(a[l],a[r])
    res=max(res,cntRes*minRes)
    while l>first or r<last:
        if r<last and (l==first or a[l-1]<a[r+1] ):
            r+=1
            cntRes+=1
            minRes=min(minRes,a[r])
        else:
            l-=1
            cntRes+=1
            minRes=min(minRes,a[l])
        res=max(res,cntRes*minRes)
    return res

n=int(input())
a=[]
for i in range(n):
    a.append(int(input()))
print(divide(0,n-1))