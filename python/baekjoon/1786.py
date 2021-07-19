t=input().rstrip()
p=input().rstrip()
n=len(t)
m=len(p)
fail=[0]*(m)

j=0
for i in range(1,m):
    while j>0 and p[i]!=p[j]:
        j=fail[j-1]
    if p[i]==p[j]:
        j+=1
        fail[i]=j
j=0
ans=[]
for i in range(n):
    while j>0 and t[i]!=p[j]:
        j=fail[j-1]
    if t[i]==p[j]:
        if j==m-1:
            ans.append(i-m+2)
            j=fail[j]
        else:
            j+=1
print(len(ans))
for i in ans:
    print(i)