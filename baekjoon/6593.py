import sys
input=sys.stdin.readline

dx=[0,0,-1,1,0,0]
dy=[-1,1,0,0,0,0]
dz=[0,0,0,0,-1,1]
def bfs(s,e):
    q=[s]
    arr[s[0]][s[1]][s[2]]=0
    while q:
        tmp=q.pop(0)
        z=tmp[0]
        x=tmp[1]
        y=tmp[2]
        if tmp==e:
            return ('Escaped in %d minute(s).' %arr[z][x][y])
        for i in range(6):
            nx=x+dx[i]
            ny=y+dy[i]
            nz=z+dz[i]
            if 0<=nx<r and 0<=ny<c and 0<=nz<l:
                if arr[nz][nx][ny]=='.' or arr[nz][nx][ny]=='E':
                    q.append([nz,nx,ny])
                    arr[nz][nx][ny]=arr[z][x][y]+1 
        
    return 'Trapped!'

while True:
    l,r,c=map(int,input().split())
    s=[]
    e=[]
    if l==0 and r==0 and c==0:
        break
    arr=[[]for i in range(l)]
    visit=[[[0]*c for i in range(r)] for i in range(l)]
    
    for i in range(l):
        for j in range(r):
            arr[i].append(list(input().strip()))
        input()
    for i in range(l):
        for j in range(r):
            for k in range(c):
                if arr[i][j][k]=='S':
                    s=[i,j,k]
                elif arr[i][j][k]=='E':
                    e=[i,j,k]
    print(bfs(s,e))