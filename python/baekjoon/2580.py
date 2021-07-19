import sys
input=sys.stdin.readline
def check(x,y,z):
    for i in range(9):
        if i!=x and s[i][y]==z:
            return False
        if i!=y and s[x][i]==z:
            return False
    a=(x//3)*3
    b=(y//3)*3
    for j in range(a,a+3):
        for k in range(b,b+3):
            if j!=x and k!=y and s[j][k]==z:
                return False
    return True
        
def dfs(num):
    if num==len(empty):
        for i in range(9):
            for j in range(9):
                print(s[i][j],end=' ')
            print()
        exit()
    x=empty[num][0]
    y=empty[num][1]
    for i in range(1,10):
        s[x][y]=i
        if check(x,y,i):
            dfs(num+1)
        s[x][y]=0

s=[]
empty=[]
for i in range(9):
    s.append(list(map(int,input().split())))
    for j in range(9):
       if s[i][j]==0:
           empty.append([i,j])
dfs(0)