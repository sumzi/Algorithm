import sys
import heapq
input=sys.stdin.readline
q=[]
n=int(input())
for i in range(n):
    m=int(input())
    if m==0:
        if not q:
            print(0)
        else:
            print(heapq.heappop(q)[1])
    else:
        heapq.heappush(q,[-m,m])