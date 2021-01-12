a=input()
num=len(a)
for i in range(num):
    if i%10==0 and i!=0:
        print()
    print(a[i],end='')