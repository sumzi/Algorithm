n=int(input())
d=[[0,1,1,1,1,1,1,1,1,1]]
for i in range(1,n+1):
    tmp=[]
    for j in range(10):
        if j==0:
            tmp.append(d[i-1][1])
        elif j==9:
            tmp.append(d[i-1][8])
        else:
            tmp.append(d[i-1][j-1]+d[i-1][j+1])
    d.append(tmp)
print(sum(d[n-1])%1000000000)