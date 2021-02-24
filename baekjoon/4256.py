from collections import deque
import sys
input=sys.stdin.readline
t=int(input())
def dfs(x,node):
    root=node.index(x)
    l=node[:root]    
    r=node[root+1:]
    if l:
        nextRoot=preorder.popleft()
        arr[x][0]=nextRoot
        if len(l)>1:
            dfs(nextRoot,l)
    if r:
        nextRoot=preorder.popleft()
        arr[x][1]=nextRoot
        if len(r)>1:
            dfs(nextRoot,r)
def postorder(x):
    if arr[x][0]!=-1:
        postorder(arr[x][0])
    if arr[x][1]!=-1:
        postorder(arr[x][1])
    print(x,end=' ')

while t>0:
    n=int(input())
    arr=[[-1,-1] for i in range(n+1)]
    preorder=deque(list(map(int,input().split())))
    inorder=list(map(int,input().split()))
    root=preorder.popleft()
    dfs(root,inorder)
    postorder(root)
    print()
    t-=1