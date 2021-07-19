import sys
input=sys.stdin.readline
n=int(input())
a=[0]*10001
for i in range(n):
    a[int(input())]+=1
for i in range(1,10001):
    for j in range(a[i]):
        print(i)