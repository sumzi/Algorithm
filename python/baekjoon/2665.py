import sys
import heapq
input=sys.stdin.readline
INF=sys.maxsize

n=int(input())
room=[]
visited=[[0]*n for i in range(n)]
dp=[[INF]*n for i in range(n)]
for i in range(n):
    room.append(list(map(int,input().rstrip())))
    for j in range(n):
        room[i][j]=(0 if room[i][j]==1 else 1)
dx=[0,0,-1,1]
dy=[-1,1,0,0]
q=[]
dp[0][0]=room[0][0]
visited[0][0]=1
heapq.heappush(q,[0,0,0])
while q:
    z,x,y=heapq.heappop(q)
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<n and 0<=ny<n and visited[nx][ny]==0:
            if dp[nx][ny]>z+room[nx][ny]:
                visited[nx][ny]=1
                dp[nx][ny]=z+room[nx][ny]
                heapq.heappush(q,[z+room[nx][ny],nx,ny])

print(dp[n-1][n-1])