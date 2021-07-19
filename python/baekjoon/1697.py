n,k=map(int,input().split())
arr=[-1]*100001
q=[n]
arr[n]=0
while q:
    x=q.pop(0)
    if x==k:
        break
    tmp=[x-1,x+1,x*2]
    for i in tmp:
        if 0<=i<=100000 and arr[i]==-1:
            q.append(i)
            arr[i]=arr[x]+1
print(arr[k])