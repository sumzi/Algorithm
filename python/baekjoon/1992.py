def divide(x,y,cnt):
    tmp=arr[x][y]
    for i in range(x,x+cnt):
        for j in range(y,y+cnt):
            if tmp!=arr[i][j]:
                tmp=-1
                break
    if tmp==-1:
        cnt//=2
        print('(',end='')
        divide(x,y,cnt)
        divide(x,y+cnt,cnt)
        divide(x+cnt,y,cnt)
        divide(x+cnt,y+cnt,cnt)
        print(')',end='')
    elif tmp==0:
        print('0',end='')
    elif tmp==1:
        print('1',end='')

n=int(input())
arr=[]
for i in range(n):
    arr.append(list(map(int,input().strip())))

divide(0,0,n)