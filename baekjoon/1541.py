n=input().split('-')
res=sum(list(map(int,n[0].split('+'))))

for i in n[1:]:
    if '+' in i:
        m=list(map(int,i.split('+')))
        res-=sum(m)
    else:
        res-=int(i)
print(res)