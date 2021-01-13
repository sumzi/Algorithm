a = []

for i in range(9):
    n = int(input())
    a.append(n)

res=sum(a)

for i in range(8):
    for j in range(i+1,9):
        if ((a[i]+a[j]) == (res-100)):
            a.pop(j)
            a.pop(i)
            a.sort()
            for k in a:
                print(k)
            exit()