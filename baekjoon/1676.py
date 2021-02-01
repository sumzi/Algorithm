n=int(input())
res=1
for i in range(n,0,-1):
    res*=i
cnt=0
res=str(res)
tmp=len(res)-1
while True:
    if res[tmp]!='0':
        break
    cnt+=1
    tmp-=1
print(cnt)