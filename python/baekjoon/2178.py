dx=[0,0,-1,1]
dy=[-1,1,0,0]

def bfs():
    arr[0][0]=0
    q=[[0,0]]
    cnt=1
    tmp=1
    while q:
        for i in range(tmp):
            x=q.pop(0)
            if x[0]==(n-1) and x[1]==(m-1):
                return cnt
            for j in range(4):
                nx=x[0]+dx[j]
                ny=x[1]+dy[j]
                if 0<=nx<n and 0<=ny<m:
                    if arr[nx][ny]==1:
                        q.append([nx,ny])
                        arr[nx][ny]=0
        cnt+=1
        tmp=len(q)

n,m=map(int,input().split())
arr=[]
for i in range(n):
    arr.append(list(map(int,input().rstrip())))
print(bfs())