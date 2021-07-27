import sys
input=sys.stdin.readline

def check():
    for i in range(1,n+1):
        cur=i
        for j in range(1,h+1):
            if arr[j][cur]==1:
                cur+=1
            elif arr[j][cur-1]==1:
                cur-=1
        if cur!=i:
            return False
    return True

def z(x,y):
    global ans
    if y>3:
        return

    if check():
        ans=min(ans,y)
        return

    for i in range(x,h+1):
        for j in range(1,n):
            if arr[i][j-1]==1 or arr[i][j]==1 or arr[i][j+1]==1:
                continue
            arr[i][j]=1
            z(i,y+1)
            arr[i][j]=0
ans=sys.maxsize
n,m,h=map(int,input().split())
arr=[[0]*(n+1) for i in range(h+1)]
for i in range(m):
    a,b=map(int,input().split())
    arr[a][b]=1
z(1,0)
print(-1 if ans==sys.maxsize else ans)