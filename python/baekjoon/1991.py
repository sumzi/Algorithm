def preorder(x):
    y=ord(x)-65
    print(x,end='')
    if dp[y][0]!='.':preorder(dp[y][0])
    if dp[y][1]!='.':preorder(dp[y][1])
def inorder(x):
    y=ord(x)-65
    if dp[y][0]!='.':inorder(dp[y][0])
    print(x,end='')
    if dp[y][1]!='.':inorder(dp[y][1])
def postorder(x):
    y=ord(x)-65
    if dp[y][0]!='.':postorder(dp[y][0])
    if dp[y][1]!='.':postorder(dp[y][1])        
    print(x,end='')
n=int(input())
dp=[[] for i in range(n)]
for i in range(n):
    tmp=list(input().split())
    a=ord(tmp[0])-65
    dp[a]=tmp[1:]
preorder('A')
print()
inorder('A')
print()
postorder('A')