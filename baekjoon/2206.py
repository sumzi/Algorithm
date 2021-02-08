import copy
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def bfs():
    q=[[[0,0,0],1]]
    arr[0][0][0]=-1
    while q:
        tmp=q.pop(0)
        z=tmp[0][0]
        x=tmp[0][1]
        y=tmp[0][2]
        num=tmp[1]
        if x==n-1 and y==m-1:
            print(num)
            return
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if z==0:
                if 0<=nx<n and 0<=ny<m:
                    if arr[z][nx][ny]==0:
                        arr[z][nx][ny]=-1
                        q.append([[z,nx,ny],num+1])
                    elif arr[z][nx][ny]==1:
                        arr[z][nx][ny]=-1
                        q.append([[z+1,nx,ny],num+1])
            elif z==1:
                if 0<=nx<n and 0<=ny<m and arr[z][nx][ny]==0:
                    arr[z][nx][ny]=1
                    q.append([[z,nx,ny],num+1])
    print(-1)


n,m=map(int,input().split())
arr=[]
tmp=[]
for i in range(n):
    tmp.append(list(map(int,input().strip())))
arr.append(tmp)
arr.append(copy.deepcopy(tmp))
bfs()