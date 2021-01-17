n=int(input())
arr=[]

for i in range(n):
    a,b=map(int,input().split())
    arr.append([a,b])

arr.sort(key=lambda x:(x[1],x[0]))

cnt=0
last=0
for i in arr:
    if last<=i[0]:
        last=i[1]
        cnt+=1

print(cnt)