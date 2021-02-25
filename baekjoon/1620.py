import sys
input=sys.stdin.readline
n,m=map(int,input().split())
arr1={}
arr2={}
for i in range(1,n+1):
    tmp=input().strip()
    arr1[i]=tmp
    arr2[tmp]=i
for i in range(m):
    tmp=input().strip()
    if tmp.isdigit():
        print(arr1[int(tmp)])
    else:
        print(arr2[tmp])