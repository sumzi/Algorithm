def dfs(num,x):
    if num==n and x=='':
        for i in s: print(i,end=' ')
        exit()
    if len(x)>=1:
        y=int(x[0])
        if y<=n and visited[y]==0:
            visited[y]=1
            s.append(y)
            dfs(num+1,x[1:])
            visited[y]=0
            s.pop()
    if len(x)>=2:
        y=int(x[:2])
        if y<=n and visited[y]==0:
            visited[y]=1
            s.append(y)
            dfs(num+1,x[2:]) 
            visited[y]=0
            s.pop()

k=input().strip()
n=len(k)
if n>9:
    n=(n-9)//2+9
visited=[0]*(n+1)
s=[]
dfs(0,k)