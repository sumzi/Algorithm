import sys
sys.setrecursionlimit(100000)
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def dfs1(x,y,c):
    tmp=1
    p1[x][y]=1
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<n and 0<=ny<n:
            if arr[nx][ny]==c and p1[nx][ny]==0:
                tmp+=dfs1(nx,ny,c)                
    return tmp

def dfs2(x,y,c):
    tmp=1
    p2[x][y]=1
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<n and 0<=ny<n:
            if p2[nx][ny]==0:
                if arr[nx][ny]==c:
                    tmp+=dfs2(nx,ny,c)
                elif c=='R' and arr[nx][ny]=='G':
                    tmp+=dfs2(nx,ny,c)
    return tmp

n=int(input())
arr=[]
for i in range(n):
    arr.append(list(input().rstrip()))
p1=[[0]*n for i in range(n)]
p2=[[0]*n for i in range(n)]
cnt1=cnt2=0

for i in range(n):
    for j in range(n):
        if p1[i][j]==0:
            dfs1(i,j,arr[i][j])
            cnt1+=1
        if p2[i][j]==0:
            temp=arr[i][j]
            if temp=='G':
                temp='R'
            dfs2(i,j,temp)
            cnt2+=1
print(cnt1,cnt2)