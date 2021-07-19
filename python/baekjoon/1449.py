import sys
input=sys.stdin.readline

n,l=map(int,input().split())
a=list(map(int,input().split()))
a.sort()
start=0
t=0

for i in a:
    if start<i:
        start=i+l-1
        t+=1

print(t)