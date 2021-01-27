import sys
input=sys.stdin.readline

n=int(input())
a={}
for i in range(n):
    tmp=int(input())
    if tmp in a:
        a[tmp]+=1
    else:
        a[tmp]=1

print(sorted(a.items(),key=lambda x:(-x[1],x[0]))[0][0])