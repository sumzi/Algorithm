def solution(progresses, speeds):
    answer = []
    n=len(progresses)
    day=0
    while n>0:
        day+=1
        for i in range(n):
            progresses[i]+=speeds[i]
        tmp=0
        for i in range(n):
            if progresses[0]>=100:
                n-=1
                progresses.pop(0)
                speeds.pop(0)
                tmp+=1
        if tmp!=0:
            answer.append(tmp)
    return answer