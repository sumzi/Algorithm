import sys
import heapq
input=sys.stdin.readline
n=int(input())
minN=[]
maxN=[]
mid=int(input())
print(mid)
for i in range(1,n):
    m=int(input())
    if i%2==1:
        if mid>m:
            heapq.heappush(minN,-m)
            heapq.heappush(maxN,mid)
        else:
            heapq.heappush(maxN,m)
            heapq.heappush(minN,-mid)
        mid=min(-minN[0],maxN[0])
    else:
        mid=m
        if -minN[0]>m:
            heapq.heappush(minN,-mid)
            mid=-heapq.heappop(minN)
        elif maxN[0]<m:
            heapq.heappush(maxN,mid)
            mid=heapq.heappop(maxN)
    print(mid)