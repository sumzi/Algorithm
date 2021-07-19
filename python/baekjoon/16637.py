import sys
input=sys.stdin.readline
def dfs(x,idx):
    global ans
    if idx==n:
        ans=max(ans,x)
        return
    dfs(eval(str(x)+m[idx:idx+2]),idx+2)
    if idx<=n-4:
        tmp=eval(m[idx+1:idx+4])
        dfs(eval(str(x)+m[idx]+str(tmp)),idx+4)

n=int(input())
m=input().strip()
ans=-sys.maxsize
dfs(int(m[0]),1)
if n>2:
    dfs(eval(m[:3]),3)
print(ans)