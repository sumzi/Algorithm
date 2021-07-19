def divide(first,last):
    if first==last:
        return a[first]*a[first]

    mid=(first+last)//2
    res=max(divide(first,mid),divide(mid+1,last))
    l=mid
    r=mid+1
    sumRes=a[l]+a[r]
    minRes=min(a[l],a[r])
    res=max(res,sumRes*minRes)

    while l>first or r<last:
        if r<last and (l==first or a[l-1]<a[r+1]):
            r+=1
            sumRes+=a[r]
            minRes=min(minRes,a[r])
        else:
            l-=1
            sumRes+=a[l]
            minRes=min(minRes,a[l])
        res=max(res,sumRes*minRes)
    return res

n=int(input())
a=list(map(int,input().split()))
print(divide(0,n-1))