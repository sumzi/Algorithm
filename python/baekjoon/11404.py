import sys
input=sys.stdin.readline
INF=sys.maxsize
n=int(input())
m=int(input())
city=[[INF]*(n+1) for i in range(n+1)]
for i in range(1,n+1):
    city[i][i]=0
for i in range(m):
    a,b,c=map(int,input().split())
    city[a][b]=min(city[a][b],c)
for i in range(1,n+1):
    for j in range(1,n+1):
        for k in range(1,n+1):
            city[j][k]=min(city[j][k],city[j][i]+city[i][k])
for i in range(1,n+1):
    for j in range(1,n+1):
        if city[i][j]==INF:
            print(0,end=' ')
        else:
            print(city[i][j],end=' ')
    print()