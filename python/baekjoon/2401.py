import sys
input=sys.stdin.readline
l=input().rstrip()
n=int(input())
short=[]
fail=[]
dp=[0]*(len(l)+1)
for _ in range(n):
    s=input().rstrip()
    m=len(s)
    short.append(s)
    tmp=[0]*m
    j=0
    for i in range(1,m):
        while j>0 and s[i]!=s[j]:
            j=tmp[j-1]
        if s[i]==s[j]:
            j+=1
            tmp[i]=j
    fail.append(tmp)
memory=[0]*501
for i in range(1,len(l)+1):
    dp[i]=dp[i-1]
    for j in range(n):
        while memory[j]>0 and short[j][memory[j]]!=l[i-1]:
            memory[j]=fail[j][memory[j]-1]
        if short[j][memory[j]]==l[i-1]:
            memory[j]+=1
            if memory[j]==len(short[j]):
                dp[i] = max(dp[i], dp[i - len(short[j])] + len(short[j]))
                memory[j]=fail[j][-1]
print(dp[-1])