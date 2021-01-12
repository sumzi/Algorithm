a=int(input())
arr=list()
for i in range(a):
    arr.append(int(input()))
arr.sort()
for i in range(len(arr)):
    print(arr[i])