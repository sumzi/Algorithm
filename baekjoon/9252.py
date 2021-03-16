import sys
input=sys.stdin.readline
n=[0]+list(input().strip())
m=[0]+list(input().strip())
nn=len(n)
mm=len(m)
dp=[['']*mm for i in range(nn)]
for i in range(1,nn):
    for j in range(1,mm):
        if n[i]==m[j]:
            dp[i][j]=dp[i-1][j-1]+n[i]
        else:
            if len(dp[i-1][j])>len(dp[i][j-1]):
                dp[i][j]=dp[i-1][j]
            else:
                dp[i][j]=dp[i][j-1]

print(len(dp[-1][-1]))
print(dp[-1][-1])