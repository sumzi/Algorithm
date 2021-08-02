import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**9)

dx=[0,0,-1,1]
dy=[-1,1,0,0]

def dfs(x,y,z):
    visited[x][y]=1
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<n and 0<=ny<n and visited[nx][ny]==0 and arr[nx][ny]>z:
            dfs(nx,ny,z)

n=int(input())
arr=[list(map(int,input().split())) for i in range(n)]
visited=[]
num=0
ans=1
for i in arr:
    num=max(num,max(i))
for i in range(1,num+1):
    visited=[[0]*n for i in range(n)]
    tmp=0
    for a in range(n):
        for b in range(n):
            if visited[a][b]==0 and arr[a][b]>i:
                dfs(a,b,i)
                tmp+=1
    ans=max(ans,tmp)
print(ans)