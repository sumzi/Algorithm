n=input()
a=[0]*26
for i in n:
    a[ord(i)-97]+=1
for i in a:
    print(i,end=" ")