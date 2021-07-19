n=int(input())
dist=list(map(int,input().split()))
dist.append(0)
cost=list(map(int,input().split()))
d=[0]*n
d[0]=dist[0]*cost[0]
minCost=cost[0]

for i in range(1,n):
    if minCost>cost[i]:
        minCost=cost[i]
    d[i]=d[i-1]+(dist[i]*minCost)
print(d[n-1])