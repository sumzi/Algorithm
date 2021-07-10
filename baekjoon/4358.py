import sys
input=sys.stdin.readline

dp={}
tree=[]
cnt=0
while 1:
    name=input().rstrip()
    if name=='':
        break
    if name in dp:
        dp[name]+=1
    else:
        tree.append(name)
        dp[name]=1
    cnt+=1
tree.sort()
for i in tree:
    print("%s %.4f" %(i, dp[i]*100/cnt))