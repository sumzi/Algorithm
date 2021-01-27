import sys
input=sys.stdin.readline

n=int(input())
stu=[]
for i in range(n):
    stu.append(list(input().split()))

stu.sort(key=lambda x:(-int(x[1]),int(x[2]),-int(x[3]),x[0]))
for i in range(n):
    print(stu[i][0])