N,B=map(int,input().split())
a=''

while N!=0:
    tmp=N%B
    if tmp>=10:
        a+=chr(tmp+55)
    else:
        a+=str(tmp)
    N//=B

print(a[::-1])