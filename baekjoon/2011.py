n=input()
dp=[0]*(len(n)+1)

if n[0] == '0':
    print(0)
    exit()
dp[0]=dp[1] = 1

for i in range(2, len(n)+1):
    if n[i-1] != '0':
        dp[i] = dp[i-1]
    tmp=int(n[i-2:i])
    if 10<=tmp and tmp<=26:
        dp[i]+=dp[i-2]

print(dp[len(n)]%1000000)