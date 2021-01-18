import sys
input=sys.stdin.readline

n,k=map(int,input().split())
arr=list(map(int,input().split()))
plug=[0]*n
num=cnt=0;

for i in arr:
    if i in plug:
        num+=1
        continue

    if 0 in plug:
        plug[plug.index(0)]=i
        num+=1
        continue

    tmp=0
    high=0
    for j in plug:
        if j not in arr[num:]:
            tmp=j
            break
        elif arr[num:].index(j)>high:
            high=arr[num:].index(j)
            tmp=j
            
    plug[plug.index(tmp)]=i
    cnt+=1
    num+=1

print(cnt)