import sys
input=sys.stdin.readline
n=int(input())
for i in range(n):
    m=input()
    cnt=0
    for i in m:
        if i=='(':
            cnt+=1
        elif i==')':
            cnt-=1
        if cnt<0:
            break
    if cnt==0:
        print("YES")
    else:
        print("NO")