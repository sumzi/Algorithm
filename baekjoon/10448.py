t=[i*(i+1)//2 for i in range(1,46)]
eureka=[0]*1001

for i in t:
    for j in t:
        for k in t:
            if i+j+k<1001:
                eureka[i+j+k]=1

n=int(input())
for i in range(n):
    print(eureka[int(input())]) 