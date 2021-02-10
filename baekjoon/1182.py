cnt=0
def dfs(cur,res):
    global cnt
    if cur==n:
        return
    if (res+arr[cur])==s:
        cnt+=1
    dfs(cur+1,res+arr[cur])
    dfs(cur+1,res)

n,s=map(int,input().split())
arr=list(map(int,input().split()))
dfs(0,0)
print(cnt)