n=input()
a=[]
for i in n:
    if i.isalpha():
        if i.isupper():
            tmp=(ord(i)-65+13)%26
            a.append(chr(tmp+65))
        else:
            tmp=(ord(i)-97+13)%26
            a.append(chr(tmp+97))
    else:
        a.append(i)
print("".join(a))