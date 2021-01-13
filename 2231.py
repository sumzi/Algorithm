n=int(input())
minNum=0
for i in range(1,n+1):
    m=list(map(int,str(i)))
    sumNum=i+sum(m)
    if(sumNum==n):
        minNum=i
        break
print(minNum)