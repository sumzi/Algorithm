def check(pos,last,used):
    if pos==n:
        tmp=(1 if used==(1<<10)-1 else 0)
        return tmp
    if dp[pos][last][used]!=-1:
        return dp[pos][last][used]
    
    tmp=0
    if last!=9:
        tmp+=check(pos+1,last+1,used|(1<<(last+1)))
    if last!=0:
        tmp+=check(pos+1,last-1,used|(1<<(last-1)))
    dp[pos][last][used]=tmp
    return tmp

n=int(input())
dp=[[[-1]*(1<<10) for i in range(10)] for i in range(n)]
res=0
for i in range(1,10):
    res+=check(1,i,(1<<i))
print(res%1000000000)