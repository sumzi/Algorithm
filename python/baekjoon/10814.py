import sys
input=sys.stdin.readline

n=int(input())
a=[]
for i in range(n):
    a.append(list(input().split()))
a.sort(key=lambda x:int(x[0]))
for i in range(n):
    print(a[i][0],a[i][1])