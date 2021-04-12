from collections import deque
import sys
input=sys.stdin.readline

t=int(input())
while t>0:
  p=input().strip()
  n=int(input())
  flag=False
  tmp=input().strip()[1:-1]
  m=deque()
  if n!=0:
    m+=list(tmp.split(','))
  for i in p:
    if i=='R':
      flag=(False if flag else True)
    else:
      if n>0:
        if flag:
          m.pop()
        else:
          m.popleft()
      n-=1
  if n==0:
    print([])
  elif n<0:
    print('error')
  else:
    print('[',end='')
    if flag:
      for i in range(n-1):
        print(m.pop(),end=',')
      print(m.pop(),end=']')
    else:
      for i in range(n-1):
        print(m.popleft(),end=',')
      print(m.popleft(),end=']')
    print()
  t-=1