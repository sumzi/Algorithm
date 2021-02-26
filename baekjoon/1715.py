import sys
import heapq
input=sys.stdin.readline
n=int(input())
q=[]
for i in range(n):
    heapq.heappush(q,int(input()))
res=0
while len(q)>1:
    tmp=heapq.heappop(q)+heapq.heappop(q)
    res+=tmp
    heapq.heappush(q,tmp)
print(res)