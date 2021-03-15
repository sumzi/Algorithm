import sys
input=sys.stdin.readline
n=input().strip()
m=input().strip()
nn=len(n)
mm=len(m)
dp=[[0]*(mm+1) for i in range(nn+1)]
for i in range(nn):
    for j in range(mm):
        if n[i]==m[j]:
            dp[i+1][j+1]=dp[i][j]+1
        else:
            dp[i+1][j+1]=max(dp[i+1][j],dp[i][j+1])
print(dp[-1][-1])