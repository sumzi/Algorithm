import sys
input=sys.stdin.readline
n=int(input())
arr=[]
dp=[[0]*3 for i in range(n)]
for i in range(n):
    arr.append(list(map(int,input().split())))
dp[0]=arr[0]
for i in range(1,n):
    dp[i][0]=min(dp[i-1][1],dp[i-1][2])+arr[i][0]
    dp[i][1]=min(dp[i-1][0],dp[i-1][2])+arr[i][1]
    dp[i][2]=min(dp[i-1][1],dp[i-1][0])+arr[i][2]
print(min(dp[n-1]))