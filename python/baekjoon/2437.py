n=int(input())
arr=list(map(int,input().split()))
arr.sort()
if arr[0]!=1:
    print(1)
else:
    ans=1
    for i in range(1,n):
        if arr[i]>ans+1:
            break
        ans+=arr[i]
    print(ans+1)