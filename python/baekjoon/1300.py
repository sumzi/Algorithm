n=int(input())
k=int(input())
start=1
end=k
ans=1
while start<=end:
    cnt=0
    mid=(start+end)//2
    for i in range(1,n+1):
        cnt+=min(n,mid//i)
    if cnt<k:
        start=mid+1
    else:
        ans=mid
        end=mid-1
print(ans)