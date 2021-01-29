n=input()
a=[-1]*26
for i in range(len(n)):
    tmp=ord(n[i])-97
    if a[tmp]==-1:
        a[tmp]=i
for i in a:
    print(i,end=" ")