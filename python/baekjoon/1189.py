dx=[0,0,-1,1]
dy=[-1,1,0,0]
def dfs(x,y,num):
    global ans
    if x==0 and y==c-1 and num==k:
        ans+=1
        return
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<r and 0<=ny<c and arr[nx][ny]=='.':
            arr[x][y]='T'
            dfs(nx,ny,num+1)
            arr[x][y]='.'

r,c,k=map(int,input().split())
arr=[list(input()) for i in range(r)]
ans=0
dfs(r-1,0,1)
print(ans)