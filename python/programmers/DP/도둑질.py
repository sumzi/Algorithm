def solution(money):
    n=len(money)
    dp=[[0,0] for i in range(n+1)]
    dp[1][0]=money[0]
    dp[2][0]=money[0]
    dp[2][1]=money[0]
    for i in range(2,n+1):
        dp[i][0]=max(dp[i-2][1],dp[i-1][1])+money[i-1]
        dp[i][1]=dp[i-1][0]
    answer=max(dp[n-1][0],dp[n-2][0])
    dp[2][0]=money[1]
    dp[2][1]=0
    for i in range(3,n+1):
        dp[i][0]=max(dp[i-2][1],dp[i-1][1])+money[i-1]
        dp[i][1]=dp[i-1][0]
    answer=max(answer,dp[n][0])
    return answer