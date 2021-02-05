import sys
input=sys.stdin.readline
def bfs():
    q=[S]
    arr[S]=0
    while q:
        x=q.pop(0)
        if x==G:
            return arr[x]
        if x+U<=F and arr[x+U]==-1:
            q.append(x+U)
            arr[x+U]=arr[x]+1
        if x-D>0 and arr[x-D]==-1:
            q.append(x-D)
            arr[x-D]=arr[x]+1
    return "use the stairs"

F,S,G,U,D=map(int,input().split())
arr=[-1]*(F+1)
print(bfs())