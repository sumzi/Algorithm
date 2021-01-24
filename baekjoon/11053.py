n = int(input())
a = list(map(int, input().split()))
dp = [1]*n
res=0

for i in range(n):
    tmp = 0
    for j in range(0, i):
        if a[i] > a[j]:
            tmp = max(tmp, dp[j])
    dp[i]=tmp+1
    res=max(res,dp[i])
print(res)