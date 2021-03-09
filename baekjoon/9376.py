import heapq
import sys
input=sys.stdin.readline
dx=[-1,1,0,0]
dy=[0,0,-1,1]
INF=sys.maxsize

def dijkstra(x,y):
    q=[[0,x,y]]
    dp=[[INF]*(w+2) for i in range(h+2)]
    dp[x][y]=0
    while q:
        cur,x,y=heapq.heappop(q)
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<h+2 and 0<=ny<w+2:
                if arr[nx][ny]=='.':
                    if cur<dp[nx][ny]:
                        dp[nx][ny]=cur
                        heapq.heappush(q,[cur,nx,ny])
                elif arr[nx][ny]=='#':
                    if cur+1<dp[nx][ny]:
                        dp[nx][ny]=cur+1
                        heapq.heappush(q,[cur+1,nx,ny])
    return dp

t=int(input())
while t>0:
    sin=[]
    h,w=map(int,input().split())
    arr=[['.'] for i in range(h+2)]
    for i in range(h+2):
        if i==0 or i==h+1:
            arr[i]+=['.']*(w+2)
        else:
            arr[i]+=list(input().strip())
            arr[i]+=['.']
    for i in range(1,h+1):
        for j in range(1,w+1):
            if arr[i][j]=='$':
                sin.append([i,j])
                arr[i][j]='.'

    case1=dijkstra(0,0)
    case2=dijkstra(sin[0][0],sin[0][1])
    case3=dijkstra(sin[1][0],sin[1][1])
    ans=INF
    for i in range(h+2):
        for j in range(w+2):
            if case1[i][j]!=INF and case2[i][j]!=INF and case3[i][j]!=INF:
                cnt=case1[i][j]+case2[i][j]+case3[i][j]
                if arr[i][j]=='#':
                    cnt-=2
                ans=min(ans,cnt)
    print(ans)    
    t-=1