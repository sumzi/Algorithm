n=int(input())
dp=[[1 for i in range(10)]]
for i in range(1,n):
    tmp=[1]
    for j in range(1,10):
        tmp.append(tmp[j-1]+dp[i-1][j])
    dp.append(tmp)
print(sum(dp[n-1])%10007)