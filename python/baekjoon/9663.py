res=0
def check(x):
    for i in range(x):
        if arr[x]==arr[i] or abs(arr[x]-arr[i])==x-i:
            return False
    return True

def dfs(num):
    global res
    if num==n:
        res+=1
        return
    for i in range(n):
        arr[num]=i
        if check(num):
            dfs(num+1)

n=int(input())
arr=[-1]*n
dfs(0)
print(res)