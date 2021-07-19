n=int(input())
a=[0]
for i in range(n):
    a.append(int(input()))
dp1=[0,a[1]]
dp2=[0,a[1]]
for i in range(2,n+1):
    tmp=max(dp1[i-2],dp2[i-2])
    dp1.append(tmp+a[i])
    dp2.append(dp1[i-1]+a[i])

print(max(dp1[n],dp2[n]))