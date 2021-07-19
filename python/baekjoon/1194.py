from collections import deque
import sys
input=sys.stdin.readline
dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs():   
    while q:
        tmp=q.popleft()
        x=tmp[0]
        y=tmp[1]
        key=tmp[2]
        cnt=tmp[3]
        if arr[x][y]=='1':
            return cnt
        
        for j in range(4):
            nx=x+dx[j]
            ny=y+dy[j]
            if 0<=nx<n and 0<=ny<m:
                if dp[nx][ny][key]==-1 and arr[nx][ny]!='#':
                    if arr[nx][ny].isupper():
                        if key& 1<<(ord(arr[nx][ny])-65):
                            q.append([nx,ny,key,cnt+1])
                            dp[nx][ny][key]=1
                    elif arr[nx][ny].islower():
                        tmp=key|1<<(ord(arr[nx][ny])-97)
                        if dp[nx][ny][tmp]==-1:
                            q.append([nx,ny,tmp,cnt+1])
                            dp[nx][ny][tmp]=1
                    elif arr[nx][ny]=='.' or arr[nx][ny]=='1' :
                        q.append([nx,ny,key,cnt+1])
                        dp[nx][ny][key]=1
      
    return -1

n,m=map(int,input().split())
arr=[list(input().strip()) for i in range(n)]
dp=[[[-1]*64 for i in range(m)] for i in range(n)]
q=deque()
for i in range(n):
    for j in range(m):
        if arr[i][j]=='0':
            arr[i][j]='.'
            q.append([i,j,0,0])
print(bfs())