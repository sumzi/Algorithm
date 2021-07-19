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
        if 0<=nx<n and 0<=ny<n:
            if arr[nx][ny]:
                tmp+=dfs(nx,ny)
    return tmp

n=int(input())
arr=[]
res=[]

for i in range(n):
    arr.append(list(map(int,input().strip())))

for i in range(n):
    for j in range(n):
        if arr[i][j]:
            res.append(dfs(i,j))
print(len(res))
res.sort()
for i in res:
    print(i)