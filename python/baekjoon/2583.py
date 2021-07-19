import sys
sys.setrecursionlimit(100000)
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def dfs(x,y):
    arr[x][y]=1
    tmp=1
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<n and 0<=ny<m:
            if arr[nx][ny]==0:
                tmp+=dfs(nx,ny)
    return tmp

n,m,k=map(int,input().split())
arr=[[0]*m for i in range(n)]
for i in range(k):
    a=list(map(int,input().split()))
    for x in range(a[1],a[3]):
        for y in range(a[0],a[2]):
            arr[x][y]=1
res=[]
for i in range(n):
    for j in range(m):
        if arr[i][j]==0:
            res.append(dfs(i,j))
print(len(res))
res.sort()
for i in res:
    print(i,end=' ')