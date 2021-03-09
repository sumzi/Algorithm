import heapq
import sys
input=sys.stdin.readline

dx=[0,0,-1,1]
dy=[-1,1,0,0]
INF=sys.maxsize
n,m=map(int,input().split())
arr=[]
dp=[[INF]*n for i in range(m)]
for i in range(m):
    arr.append(list(map(int,input().strip())))
dp[0][0]=0
q=[]
heapq.heappush(q,[0,0,0])
while q:
    cur,x,y=heapq.heappop(q)
    if cur>dp[x][y]:
        continue
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<m and 0<=ny<n:
            tmp=cur+arr[nx][ny]
            if tmp<dp[nx][ny]:
                dp[nx][ny]=tmp
                heapq.heappush(q,[tmp,nx,ny])
print(dp[m-1][n-1])