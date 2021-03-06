def divide(x,y,cnt):
    global p1,p2,p3
    tmp=arr[x][y]
    for i in range(x,x+cnt):
        for j in range(y,y+cnt):
            if tmp!=arr[i][j]:
                tmp=2
                break
    if tmp==2:
        cnt//=3
        for i in range(3):
            for j in range(3):
                divide(x+cnt*i,y+cnt*j,cnt)
    elif tmp==-1:
        p1+=1
    elif tmp==0:
        p2+=1
    elif tmp==1:
        p3+=1

n=int(input())
p1=p2=p3=0
arr=[]
for i in range(n):
    arr.append(list(map(int,input().split())))
divide(0,0,n)
print(p1)
print(p2)
print(p3)