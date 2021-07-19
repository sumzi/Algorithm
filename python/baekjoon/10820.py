import sys
while True:
    n=sys.stdin.readline().rstrip('\n')
    a=b=c=d=0
    if not n:
        break
    for i in n:
        if i.islower():
            a+=1
        elif i.isupper():
            b+=1
        elif i.isdigit():
            c+=1
        elif i.isspace():
            d+=1
    print(a,b,c,d)