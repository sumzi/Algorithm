import sys
input=sys.stdin.readline
def divide(x):
    if x==1:
        return a%c
    tmp=divide(x//2)
    if x%2==0:
        return tmp*tmp%c
    else:    
        return tmp*tmp*a%c

a,b,c=map(int,input().split())
print(divide(b))