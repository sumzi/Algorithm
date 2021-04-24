def solution(absolutes, signs):
    res = 0
    for i in range(len(absolutes)):
        if signs[i]:
            res+=absolutes[i]
        else:
            res-=absolutes[i]    
    return res
print(solution([4,7,12],[True,False,True]))