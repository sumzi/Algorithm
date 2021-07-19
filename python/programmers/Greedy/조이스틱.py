def solution(name):
    answer = 0
    n=len(name)
    cnt=n
    m=0
    dp=[0]*n
    for i in range(n):
        if name[i]=='A':
            dp[i]=1
            cnt-=1
    def check(x):
        for i in range(1,n):
            if dp[(x+i)%n]==0:
                return (i,(x+i)%n)
            elif dp[x-i]==0:
                tmp= x-i if x-i>-1 else n+(x-i)
                return (i,tmp)
        return (0,0)
    if dp[0]==1:
        a,b=check(0)
        answer+=a
        m=b
    while cnt>0:
        tmp=ord(name[m])-ord('A')
        answer+=(min(tmp,26-tmp))
        dp[m]=1
        if n==1:
            cnt-=1
            break
        (a,b)=check(m)
        answer+=a
        m=b
        cnt-=1
    return answer