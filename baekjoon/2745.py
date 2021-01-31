n,b=input().split()
b=int(b)
tmp=1
res=0
for i in n[::-1]:
    if i.isalpha():
        res+= ((ord(i)-55)*tmp)
    else:
        res+=(int(i)*tmp)
    tmp*=b
print(res)