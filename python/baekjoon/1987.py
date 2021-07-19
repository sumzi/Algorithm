import sys
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]
maxNum=0
def dfs(num,alpha,x,y):
    global maxNum
    for i in range(4):
        nx=dx[i]+x
        ny=dy[i]+y
        if 0<=nx<r and 0<=ny<c:
            if arr[nx][ny] not in alpha:
                dfs(num+1,alpha+arr[nx][ny],nx,ny)
    maxNum=max(maxNum,num)

r,c=map(int,input().split())
arr=[]
for i in range(r):
    arr.append(list(input()))
dfs(1,arr[0][0],0,0)
print(maxNum)