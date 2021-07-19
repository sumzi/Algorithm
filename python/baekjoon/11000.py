import sys
import heapq
input=sys.stdin.readline

arr=[]
n=int(input())
for i in range(n):
    a,b=map(int,input().split())
    arr.append([a,b])

arr.sort()
pq=[]
heapq.heappush(pq,arr[0][1])
for i in range(1,n):
    if pq[0]>arr[i][0]:
        heapq.heappush(pq,arr[i][1])
    else:
        heapq.heappop(pq)
        heapq.heappush(pq,arr[i][1])

print(len(pq))