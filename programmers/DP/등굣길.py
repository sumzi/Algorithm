dx=[0,1]
dy=[1,0]

def dfs(x,y,n,m,dp):
    if x==n-1 and y==m-1:
        return 1
    if dp[x][y]>-1:
        return dp[x][y]
    tmp=0
    for i in range(2):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<n and 0<=ny<m:
            if dp[nx][ny]!=-2:
                tmp+=dfs(nx,ny,n,m,dp)
    dp[x][y]=tmp%1000000007
    return dp[x][y]

def solution(m, n, puddles):
    dp=[[-1]*m for i in range(n)]
    for x,y in puddles:
        dp[y-1][x-1]=-2
    return dfs(0,0,n,m,dp)