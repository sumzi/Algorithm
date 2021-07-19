n=input()
res=cnt=0
for i in range(len(n)):
    if n[i:i+2]=='()':
        res+=cnt
    if n[i]=='(':
        cnt+=1
    elif n[i]==')':
        cnt-=1
        if n[i-1:i+1]!='()':
            res+=1
print(res)