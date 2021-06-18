import sys
input=sys.stdin.readline
dx=[0,1,1]
dy=[1,1,0]
def dfs(x,y,z):
    if x==n-1 and y==n-1:
        return 1
    if dp[x][y][z]>-1:
        return dp[x][y][z]
    tmp=0
    if z==0:
        for i in range(2):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and arr[nx][ny]==0:
                if i==1:
                    if arr[x+1][y] or arr[x][y+1]:
                        continue
                tmp+=dfs(nx,ny,i)
    elif z==1:
        for i in range(3):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and arr[nx][ny]==0:
                if i==1:
                    if arr[x+1][y] or arr[x][y+1]:
                        continue
                tmp+=dfs(nx,ny,i)
    else:
        for i in range(1,3):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and arr[nx][ny]==0:
                if i==1:
                    if arr[x+1][y] or arr[x][y+1]:
                        continue
                tmp+=dfs(nx,ny,i)

    dp[x][y][z]=tmp
    return dp[x][y][z]        

n=int(input())
arr=[]
dp=[[[-1]*3 for i in range(n)] for i in range(n)]
for i in range(n):
    arr.append(list(map(int,input().split())))
print(dfs(0,1,0))