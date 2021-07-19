import sys
import heapq
input=sys.stdin.readline
t=int(input())
while t>0:
    m=int(input())
    n=m//10
    arr=[]
    for i in range(n+1):
        arr+=list(map(int,input().split()))
    mid=[arr[0]]
    maxq=[]
    minq=[]
    for i in range(1,m):
        x=arr[i]
        if i%2==0:
            #홀수일때
            if x<maxq[0][1]:
                heapq.heappush(maxq,[-(x+10000),x])
                mid.append(heapq.heappop(maxq)[1])
            else:
                heapq.heappush(minq,x)
                mid.append(heapq.heappop(minq))
        else:
            #짝수일때
            y=mid[-1]
            if y>x:
                heapq.heappush(maxq,[-(x+10000),x])
                heapq.heappush(minq,y)
            else:
                heapq.heappush(maxq,[-(y+10000),y])
                heapq.heappush(minq,x)
    tmp=len(mid)
    print(tmp)
    for i in range(tmp//10+1):
        for j in mid[0+(10*i):10+(10*i)]:
            print(j,end=' ')
        print()
    t-=1