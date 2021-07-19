import sys
input=sys.stdin.readline
n=list(input().strip())
m=int(input())
n2=[]
for i in range(m):
    a=input()
    if a[0]=='L':
        if n:
            n2.append(n.pop())
    elif a[0]=='D':
        if n2:
            n.append(n2.pop())
    elif a[0]=='B':
        if n:
            n.pop()
    else:
        n.append(a[2])
print(''.join(n+list(reversed(n2))))