import sys
input=sys.stdin.readline
t=int(input())
while t>0:
    n=int(input())
    arr=[]
    for i in range(n):
        arr.append(input().rstrip())
    arr.sort()
    flag='YES'
    for i in range(n-1):
        m=len(arr[i])
        if arr[i]==arr[i+1][:m]:
            flag='NO'
            break
    print(flag)
    t-=1