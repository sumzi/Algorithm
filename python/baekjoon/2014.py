import sys
import heapq
input=sys.stdin.readline
k,n=map(int,input().split())
q=[]
arr=list(map(int,input().split()))
for i in arr:
    heapq.heappush(q,i)
x=0
for i in range(n):
    x=heapq.heappop(q)
    for j in arr:
        heapq.heappush(q,j*x)
        if x%j==0:
            break
print(x)