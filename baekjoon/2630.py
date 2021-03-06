def divide(x,y,cnt):
    global w,b
    tmp=arr[x][y]
    for i in range(x,x+cnt):
        for j in range(y,y+cnt):
            if tmp!=arr[i][j]:
                tmp=-1
                break
    if tmp==-1:
        cnt//=2
        divide(x,y,cnt)
        divide(x,y+cnt,cnt)
        divide(x+cnt,y,cnt)
        divide(x+cnt,y+cnt,cnt)
    elif tmp==0:
        w+=1
    elif tmp==1:
        b+=1
n=int(input())
arr=[]
w=0
b=0
for i in range(n):
    arr.append(list(map(int,input().split())))
divide(0,0,n)
print(w)
print(b)