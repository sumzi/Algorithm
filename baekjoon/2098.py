import sys 
def tsp(cur,visited):
    if visited==(1<<n)-1: 
        if w[cur][0]!=0:
            return w[cur][0]
        return sys.maxsize
    if dp[cur][visited]!=-1:
        return dp[cur][visited]

    tmp=sys.maxsize
    for i in range(n):
        if visited & (1<<i) == 0 and w[cur][i]!=0:
            tmp=min(tmp,tsp(i,visited|(1<<i))+w[cur][i])
    dp[cur][visited]=tmp
    return tmp
    
n=int(sys.stdin.readline()) 
w=[list(map(int,sys.stdin.readline().split())) 
for i in range(n)] 
dp=[[-1]*(1<<n) for i in range(n)] 
print(tsp(0,1))