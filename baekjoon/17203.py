import sys
input=sys.stdin.readline
n,m=map(int,input().split())
arr=list(map(int,input().split()))
dp=[0]
for i in range(1,n):
    dp.append(abs(arr[i]-arr[i-1]))
for i in range(m):
    a,b=map(int,input().split())
    if a==b:
        print(0)
    else:
        res=0
        for j in dp[a:b]:
            res+=j
        print(res)