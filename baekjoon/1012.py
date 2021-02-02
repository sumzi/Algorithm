import sys
sys.setrecursionlimit(50000)
input= sys.stdin.readline
dx=[0,0,1,-1]
dy=[-1,1,0,0]

def dfs(x,y):
    arr[x][y]=0
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if (0<=nx<m) and (0<=ny<n) and arr[nx][ny]==1:    
            dfs(nx,ny)

t=int(input())
while t>0:
    m,n,k=map(int,input().split())
    arr=[[0]*n for i in range(m)]
    
    for i in range(k):
        a,b=map(int,input().split())
        arr[a][b]=1

    cnt=0
    for i in range(m):
        for j in range(n):
            if arr[i][j]==1:
                dfs(i,j)
                cnt+=1
    print(cnt)
    t-=1