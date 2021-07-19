import sys
input=sys.stdin.readline
s=[0]*21
n=int(input())
while n>0:
    m=input().split()   
    x=m[0]
    if x=='add':
        s[int(m[1])]=1
    elif x=='remove':
        s[int(m[1])]=0
    elif x=='check':
        print(s[int(m[1])])
    elif x=='toggle':
        s[int(m[1])]=(0 if s[int(m[1])] else 1)
    elif x=='all':
        s=[1]*21
    elif x=='empty':
        s=[0]*21
    n-=1