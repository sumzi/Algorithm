dx=[0,0,-1,1]
dy=[-1,1,0,0]
def bfs():
    scnt=len(s)
    wcnt=len(w)
    while s:
        for i in range(wcnt):
            tmp=w.pop(0)
            x=tmp[0]
            y=tmp[1]
            for j in range(4):
                nx=x+dx[j]
                ny=y+dy[j]
                if 0<=nx<n and 0<=ny<m and (arr[nx][ny]=='.' or arr[nx][ny]=='S') :
                    w.append([nx,ny])
                    arr[nx][ny]='*'
        wcnt=len(w)

        for i in range(scnt):
            tmp=s.pop(0)
            x=tmp[0][0]
            y=tmp[0][1]
            num=tmp[1]
            if tmp[0]==d:
                print(num)
                return 
            for j in range(4):
                nx=x+dx[j]
                ny=y+dy[j]
                if 0<=nx<n and 0<=ny<m and (arr[nx][ny]=='.' or arr[nx][ny]=='D'):
                    s.append([[nx,ny],num+1])
                    arr[nx][ny]='S'
        scnt=len(s)
    print('KAKTUS')

n,m=map(int,input().split())
arr=[]
s=[]
w=[]
for i in range(n):
    arr.append(list(input().strip()))
for i in range(n):
    for j in range(m):
        if arr[i][j]=='*':
            w.append([i,j])
        elif arr[i][j]=='S':
            s.append([[i,j],0])
        elif arr[i][j]=='D':
            d=[i,j]
bfs()