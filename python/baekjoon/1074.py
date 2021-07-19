import sys
input=sys.stdin.readline
def divide(x,y,cnt):
    global num
    
    if x==r and y==c:
        print(num)
        exit()
        
    cnt//=2
    for i in range(2):
        for j in range(2):
            if x+(i*cnt)<=r<x+cnt+(i*cnt) and y+(j*cnt)<=c<y+cnt+(j*cnt):
                divide(x+(i*cnt),y+(j*cnt),cnt)
            num+=(cnt*cnt)
n,r,c=map(int,input().split())
n=2**n
num=0
divide(0,0,n)