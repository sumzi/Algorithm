import sys
input=sys.stdin.readline
a=[0]*1000001
a[1]=1
b=[]
for i in range(2,1000001):
    for j in range(i+i,1000001,i):
        a[j]=1

while True:
    n=int(input())
    if n==0:
        break
    flag=False
    for i in range(3,1000001):
        if not a[i] and not a[n-i]:
            print('%d = %d + %d' %(n,i,n-i))
            flag=True
            break
    if not flag:       
        print("Goldbach's conjecture is wrong.")