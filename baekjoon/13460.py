from collections import deque
import sys
input=sys.stdin.readline
def go(loc,num):
    x=loc[0]
    y=loc[1]
    cnt=0
    while True:
        x=x+dx[num]
        y=y+dy[num]
        cnt+=1
        if 0<=x<n and 0<=y<m:
            if arr[x][y]=='O':
                return [x,y],cnt
            elif arr[x][y]=='#':
                return [x-dx[num],y-dy[num]],-cnt                     
def bfs():
    while q:
        r,b,cnt=q.popleft()
        if cnt>9:
            return -1
        for i in range(4):
            nr,nrCnt=go(r,i)
            nb,nbCnt=go(b,i)
            if nrCnt>0 and nbCnt>0:
                continue
            elif nrCnt>0:
                #   승리
                return cnt+1
            if nrCnt>0:
                continue
            if nr==nb:
                if abs(nrCnt)>abs(nbCnt):
                    nr[0]-=dx[i]
                    nr[1]-=dy[i]
                else:
                    nb[0]-=dx[i]
                    nb[1]-=dy[i]
            if [nr,nb] in visited:
                continue
            if nrCnt<0 and nbCnt<0:
                q.append([nr,nb,cnt+1])
                visited.append([nr,nb])
    return -1
dx=[0,0,-1,1]
dy=[-1,1,0,0]
n,m=map(int,input().split())
visited=[]
q=deque()
arr=[]
R=[]
B=[]
O=[]
for i in range(n):
    arr.append(list(input().strip()))
for i in range(n):
    for j in range(m):
        if arr[i][j]=='R':
            R=[i,j]
        elif arr[i][j]=='B':
            B=[i,j]
        elif arr[i][j]=='O':
            O=[i,j]
visited.append([R,B])
q.append([R,B,0])
print(bfs())