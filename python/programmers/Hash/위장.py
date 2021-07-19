def solution(clothes):
    answer = {}
    res=1
    for x,y in clothes:
        if y in answer:
            answer[y]+=1
        else:
            answer[y]=1
    for i in answer:
        res*=(answer[i]+1)
    
    return res-1