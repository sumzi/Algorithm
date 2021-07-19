import sys
import heapq
input=sys.stdin.readline
n=int(input())
q=[]
for i in range(n):
    m=int(input())
    if m==0:
        if q:
            print(heapq.heappop(q)[1])
        else:
            print(0)
    else:
        heapq.heappush(q,[abs(m),m])