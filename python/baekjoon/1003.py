import sys
input=sys.stdin.readline
arr=[[1,0],[0,1]]
for i in range(2,41):
    a=arr[i-2][0]+arr[i-1][0]
    b=arr[i-2][1]+arr[i-1][1]
    arr.append([a,b])
t=int(input())
while t>0:
    n=int(input())
    print(arr[n][0],arr[n][1])
    t-=1