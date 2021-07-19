n=input()
n=sorted(n,reverse=True)
if '0' not in n:
    print(-1)
else:
    n=list(map(int,n))
    if sum(n)%3==0:
        print(''.join(map(str,n)))
    else:
        print(-1)