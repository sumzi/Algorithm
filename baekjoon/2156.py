n=int(input())
a=[]
for i in range(n):
    a.append(int(input()))
dp=[[0,0,a[0]],[0,0,a[0]],[0,0,a[0]]]
res=a[0]
for i in range(1,n):
    dp[0].append(max(dp[2][i-1],dp[2][i])+a[i])
    dp[1].append(a[i]+dp[0][i+1])
    tmp=max(dp[0][i+2],dp[1][i+2])
    dp[2].append(tmp)
    res=max(res,dp[2][i+2])

print(res)