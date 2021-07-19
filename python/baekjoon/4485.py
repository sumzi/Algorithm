import heapq
import sys
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]
INF=sys.maxsize
cnt=1
while True:
    n=int(input())
    if n==0:
        break
    arr=[]
    dp=[[INF]*n for i in range(n)]
    for i in range(n):
        arr.append(list(map(int,input().split())))
    q=[]
    heapq.heappush(q,[arr[0][0],0,0])
    dp[0][0]=arr[0][0]
    while q:
        cur,x,y=heapq.heappop(q)
        if cur>dp[x][y]:
            continue
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                tmp=cur+arr[nx][ny]
                if tmp<dp[nx][ny]:
                    dp[nx][ny]=tmp
                    heapq.heappush(q,[tmp,nx,ny])
    print('Problem %d: %d'%(cnt,dp[n-1][n-1]))
    cnt+=1
