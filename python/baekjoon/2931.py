from collections import deque
import sys
input=sys.stdin.readline

r,c=map(int,input().split())
arr=[]
m=[]
ans=[]
dx=[-1,0,1,0]
dy=[0,1,0,-1]
f={
    '|':{0:[-1,0,0],2:[1,0,2]},
    '-':{1:[0,1,1],3:[0,-1,3]},
    '1':{3:[1,0,2],0:[0,1,1]},
    '2':{2:[0,1,1],3:[-1,0,0]},
    '3':{2:[0,-1,3],1:[-1,0,0]},
    '4':{1:[1,0,2],0:[0,-1,3]},
    '+':{0:[-1,0,0],1:[0,1,1],2:[1,0,2],3:[0,-1,3]}
}
d=[['|','1','','4'],
    ['','-','4',''],
    ['3','2','|','3'],
    ['2','','1','-']]
q=deque()
for i in range(r):
    arr.append(list(input().rstrip()))
    for j in range(c):
        if arr[i][j]=='M':
            m=[i,j]
for i in range(4):
    nx=m[0]+dx[i]
    ny=m[1]+dy[i]
    if 0<=nx<r and 0<=ny<c and arr[nx][ny]!='.' and arr[nx][ny]!='Z':
        if i in f[arr[nx][ny]]:
            q.append([nx,ny,i])
while q:
    x,y,z=q.popleft()
    if arr[x][y]=='Z':
        print(ans[0][0],ans[0][1],end=' ')
        if len(ans)==4:
            print('+')
        else:
            print(ans[1])
    elif arr[x][y]=='+':
        q.append([x+dx[z],y+dy[z],z])
    elif arr[x][y] in f:
        tmp=f[arr[x][y]][z]
        q.append([x+tmp[0],y+tmp[1],tmp[2]])
    elif arr[x][y]=='.':
        ans.append([x+1,y+1])
        num=-1
        for i in range(4):
            if ((z+2)%4)==i:
                continue
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<r and 0<=ny<c and arr[nx][ny]!='.' and arr[nx][ny]!='Z' and arr[nx][ny]!='M': 
                if i in f[arr[nx][ny]]:
                    ans.append(d[z][i])
                    num=i
        if len(ans)==4:
            q.append([x+dx[z],y+dy[z],z])
            arr[x][y]='+'
        else:
            q.append([x+dx[num],y+dy[num],num])