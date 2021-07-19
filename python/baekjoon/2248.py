def skip(a,b,c):
    global ans
    if a==0:return 
    if b==0:
        for i in range(a):
            ans+='0'
        return 
    cnt=0
    for i in range(b+1):
        cnt+=dp[a-1][i]
    if cnt>=c:
        ans+='0'
        skip(a-1,b,c)
    else:
        ans+='1'
        skip(a-1,b-1,c-cnt)
N,L,I=map(int,input().split())
dp=[[0]*33 for i in range(33)]
dp[0][0]=1
ans=''
for i in range(1,33):
    dp[i][0]=1
    dp[i][i]=1
for i in range(2,N+1):
    for j in range(1,i+1):
        dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
skip(N,L,I)
print(ans)