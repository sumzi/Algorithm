import sys
input=sys.stdin.readline
n=int(input())
q=[]
for i in range(n):
    a=input().split()
    if a[0]=='push':
        q.append(a[1])
    elif a[0]=='pop':
        if not q:
            print(-1)
        else:
            print(q.pop(0))
    elif a[0]=='size':
        print(len(q))
    elif a[0]=='empty':
        if not q:
            print(1)
        else:
            print(0)
    elif a[0]=='front':
        if not q:
            print(-1)
        else:
            print(q[0])
    elif a[0]=='back':
        if not q:
            print(-1)
        else:
            print(q[-1])