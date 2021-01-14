n=int(input())
a=[list(input()) for i in range(n)]
res=0

def width():
    global res

    for i in range(n):
        c=1
        for j in range(1,n):
            if a[i][j-1]==a[i][j]:
                c+=1
            else:
                if res<c:
                    res=c
                c=1
        res=max(res,c) 

def height():
    global res

    for i in range(n):
        c=1
        for j in range(1,n):
            if a[j-1][i]==a[j][i]:
                c+=1
            else:
                if res<c:
                    res=c
                c=1
        res=max(res,c)            

for i in range(n):
    for j in range(1,n):
        a[i][j-1],a[i][j]=a[i][j],a[i][j-1]
        width()
        height()
        a[i][j-1],a[i][j]=a[i][j],a[i][j-1]
        
        a[j-1][i],a[j][i]=a[j][i],a[j-1][i]
        width()
        height()
        a[j-1][i],a[j][i]=a[j][i],a[j-1][i]

print(res)