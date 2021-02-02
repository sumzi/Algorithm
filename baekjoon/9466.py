import sys
sys.setrecursionlimit(200000)
input = sys.stdin.readline
cnt = 0


def dfs(x, y):
    global cnt
    visited[x] = y
    nx = arr[x]
    if visited[nx] == y:
        temp = nx
        while temp != x:
            cnt += 1
            temp = arr[temp]
        cnt += 1
    elif visited[nx] == 0:
        dfs(nx, y)


t = int(input())
while t > 0:
    n = int(input())
    arr = [0]
    arr += list(map(int, input().split()))
    visited = [0]*(n+1)
    cnt = 0
    tmp = 1
    for i in range(1, n+1):
        if visited[i] == 0:
            dfs(i, tmp)
            tmp += 1
    print(n-cnt)
    t -= 1
