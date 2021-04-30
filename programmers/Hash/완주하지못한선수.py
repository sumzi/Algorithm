def solution(participant, completion):
    answer = {}
    
    for i in participant:
        if i in answer:
            answer[i]+=1
        else:
            answer[i]=1
            
    for i in completion:
        if i in answer:
            answer[i]-=1
    for i in answer:
        if answer[i]:
            return i