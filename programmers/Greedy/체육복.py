def solution(n, lost, reserve):
    answer = 0
    arr=[0]*(n+2)
    for i in lost:
        arr[i]-=1
    for i in reserve:
        arr[i]+=1
    for i in range(1,n+1):
        if arr[i]>=0:
            answer+=1
        else:
            if arr[i-1]==1:
                arr[i-1]-=0
                answer+=1
            elif arr[i+1]==1:
                arr[i+1]-=1
                answer+=1
    return answer