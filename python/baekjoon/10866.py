import sys
from collections import deque
input=sys.stdin.readline
n=int(input())
de=deque()

def check():
    if not de:
        print(-1)
    else:
        return True

for i in range(n):
    a=input().split()
    if a[0]=='push_front':
        de.appendleft(a[1])
    elif a[0]=='push_back':
        de.append(a[1])
    elif a[0]=='pop_front':
        if check():
            print(de.popleft())
    elif a[0]=='pop_back':
        if check():
            print(de.pop())
    elif a[0]=='size':
        print(len(de))
    elif a[0]=='empty':
        if not de:
            print(1)
        else:
            print(0)
    elif a[0]=='front':
        if check():
            print(de[0])
    elif a[0]=='back':
        if check():
            print(de[-1])