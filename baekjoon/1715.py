import sys
import heapq
input=sys.stdin.readline
n=int(input())
q=list(map(int,input().split()))
heapq.heapify(q)
for i in range(n-1):
    tmp=list(map(int,input().split()))
    for j in tmp:
        heapq.heappush(q,j)
        heapq.heappop(q)
print(heapq.heappop(q))