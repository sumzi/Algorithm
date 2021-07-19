from collections import deque
from copy import deepcopy

def dfs(cnt,dir,tmp):
  global res
  dp=deepcopy(tmp)
  if dir==0: # left
    for i in range(n):
      q=deque()
      for j in range(n):
        if dp[i][j]:
          q.append(dp[i][j])
          dp[i][j]=0
      num=0
      while q:
        x=q.popleft()
        if dp[i][num]==0:
          dp[i][num]=x
        elif dp[i][num]==x:
          dp[i][num]*=2
          num+=1
        else:
          num+=1
          dp[i][num]=x

  elif dir==1: # right
    for i in range(n):
      q=deque()
      for j in range(n-1,-1,-1):
        if dp[i][j]:
          q.append(dp[i][j])
          dp[i][j]=0
      num=n-1
      while q:
        x=q.popleft()
        if dp[i][num]==0:
          dp[i][num]=x
        elif dp[i][num]==x:
          dp[i][num]*=2
          num-=1
        else:
          num-=1
          dp[i][num]=x
  elif dir==2: # top
    for i in range(n):
      q=deque()
      for j in range(n):
        if dp[j][i]:
          q.append(dp[j][i])
          dp[j][i]=0
      num=0
      while q:
        x=q.popleft()
        if dp[num][i]==0:
          dp[num][i]=x
        elif dp[num][i]==x:
          dp[num][i]*=2
          num+=1
        else:
          num+=1
          dp[num][i]=x

  elif dir==3: # bottom
    for i in range(n):
      q=deque()
      for j in range(n-1,-1,-1):
        if dp[j][i]:
          q.append(dp[j][i])
          dp[j][i]=0
      num=n-1
      while q:
        x=q.popleft()
        if dp[num][i]==0:
          dp[num][i]=x
        elif dp[num][i]==x:
          dp[num][i]*=2
          num-=1
        else:
          num-=1
          dp[num][i]=x

  if cnt==5:
    for i in dp:
      res=max(res,max(i))
    return
  for i in range(4):
    dfs(cnt+1,i,dp)

n=int(input())
arr=[]
res=0
for i in range(n):
  arr.append(list(map(int,input().split())))
for i in range(4):
  dfs(1,i,arr)
print(res)