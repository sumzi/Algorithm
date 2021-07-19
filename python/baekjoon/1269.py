a,b=map(int,input().split())
arrA=set(map(int,input().split()))
arrB=set(map(int,input().split()))
print(len(arrA-arrB)+len(arrB-arrA))
#   set을 이용하면 차집합을 구할수있다.