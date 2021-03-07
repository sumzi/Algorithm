def divide(x,y,cnt):
    if cnt==1:
        return 
    cnt//=3
    for i in range(3):
        for j in range(3):
            if i==1 and j==1:
                for a in range(x+(cnt*i),x+(cnt*i)+cnt):
                    for b in range(y+(cnt*j),y+(cnt*j)+cnt):
                        arr[a][b]=' '
            else:
               divide(x+(cnt*i),y+(cnt*j),cnt)
n=int(input())
arr=[['*']*n for i in range(n)]
divide(0,0,n)
for i in range(n):
    print(''.join(arr[i]))