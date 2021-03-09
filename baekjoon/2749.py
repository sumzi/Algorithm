n=int(input())
dp=[[1,1],[1,0]]
def fibo(x):
    if x==1:
        return dp
    tmp=fibo(x//2)
    res1=[[0,0],[0,0]]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                res1[i][j]+=(tmp[i][k]*tmp[k][j])%1000000
    tmp=res1
    if x%2==0:
        return tmp
    else:
        res2=[[0,0],[0,0]]
        for i in range(2):
            for j in range(2):
                for k in range(2):
                    res2[i][j]+=(tmp[i][k]*dp[k][j])%1000000
        return res2
        
print(fibo(n)[0][1]%1000000)