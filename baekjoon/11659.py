import sys
input=sys.stdin.readline
n,m=map(int,input().split())
arr=list(map(int,input().split()))
dp=[0]
res=0
for i in range(n):
    res+=arr[i]
    dp.append(res)
while m>0:
    a,b=map(int,input().split())
    print(dp[b]-dp[a-1])
    m-=1