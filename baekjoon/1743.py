import sys
sys.setrecursionlimit(100000)
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def dfs(x,y):
    tmp=1
    arr[x][y]=0
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 1<=nx<=n and 1<=ny<=m:
            if arr[nx][ny]==1:
                tmp+=dfs(nx,ny)
    return tmp
 
n,m,k=map(int,input().split())
arr=[[0]*(m+1) for i in range(n+1)]
cnt=0
for i in range(k):
    a,b=map(int,input().split())
    arr[a][b]=1

for i in range(1,n+1):
    for j in range(1,m+1):
        if arr[i][j]==1:
            temp=dfs(i,j)
            cnt=max(cnt,temp)
print(cnt)