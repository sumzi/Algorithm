import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline
def dfs(cur,leng):
    global m
    if arr[cur][0]!=-1:
        dfs(arr[cur][0],leng+1)
    m+=1
    level[leng].append(m)
    if arr[cur][1]!=-1:
        dfs(arr[cur][1],leng+1)

n=int(input())
level=[[] for i in range(n+1)]
arr=[[] for i in range(n+1)]
node=[0]*(n+1)
for i in range(n):
    a,b,c=map(int,input().split())
    arr[a]=[b,c]
    node[a]+=1
    if b!=-1:
        node[b]+=1
    if c!=-1:
        node[c]+=1
m=0
root=1
for i in range(1,n+1):
    if node[i]==1:
        root=i
dfs(root,1)
result=max(level[1])-min(level[1])+1
row=1
for i in range(2,n+1):
    if level[i]:
        if result<max(level[i])-min(level[i])+1:
            result=max(level[i])-min(level[i])+1
            row=i
print(row,result)