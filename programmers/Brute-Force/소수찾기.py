import itertools

def solution(numbers):
    answer = 0
    arr=[]
    arr2=[]
    for i in range(1,len(numbers)+1):
        arr+=itertools.permutations(numbers,i)
    for i in arr:
        arr2.append(int(''.join(i)))
    arr2=list(set(arr2))
    n=max(arr2)
    prime=[0]*(n+1)
    prime[0]=prime[1]=1
    for i in range(2,n+1):
        for j in range(i+i,n+1,i):
            prime[j]=1
    for i in arr2:
        if prime[i]==0:
            answer+=1
            prime[i]=1
    return answer