def solution(number, k):
    answer = [number[0]]
    for i in number[1:]:
        while len(answer)>0 and answer[-1]<i and k>0:
            k-=1
            answer.pop()
        answer.append(i)
    if k!=0:
        answer=answer[:-k]
    
    return ''.join(answer)