t=int(input())
dp=[0,1,1]
for i in range(3,101):
    dp.append(dp[i-3]+dp[i-2])

for i in range(t):
    print(dp[int(input())])