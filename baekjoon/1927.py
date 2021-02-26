import sys
import heapq
input=sys.stdin.readline
n=int(input())
q=[]
for i in range(n):
    m=int(input())
    if m==0:
        if not q:
            print(0)
        else:
            print(heapq.heappop(q))
    else:
        heapq.heappush(q,m)