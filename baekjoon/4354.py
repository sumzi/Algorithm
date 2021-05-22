import sys
input=sys.stdin.readline
while 1:
    s=input().rstrip()
    if s=='.':
        break
    n=len(s)
    fail=[0]*n

    j=0
    for i in range(1,n):
        while j>0 and s[i]!=s[j]:
            j=fail[j-1]
        if s[i]==s[j]:
            j+=1
            fail[i]=j
    if n%(n-fail[n-1]):
        print(1)
    else:
        print(n//(n-fail[n-1]))