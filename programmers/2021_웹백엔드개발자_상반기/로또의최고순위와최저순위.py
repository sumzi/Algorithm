def solution(lottos, win_nums):
    answer = []
    cnt=0
    num=0
    score=[6,6,5,4,3,2,1]
    for i in lottos:
        if i==0:
            cnt+=1
        else:
            if i in win_nums:
                num+=1
    answer.append(score[cnt+num])
    answer.append(score[num])
    return answer