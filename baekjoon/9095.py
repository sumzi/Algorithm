n=int(input())
d=[1,1,2]
for i in range(3,11):
    tmp=d[i-1]+d[i-2]+d[i-3]
    d.append(tmp)

for i in range(n):
    print(d[int(input())])