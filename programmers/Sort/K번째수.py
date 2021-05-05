def solution(array, commands):
    answer = []
    for i,j,k in commands:
        x=array[i-1:j]
        x.sort()
        answer.append(x[k-1])
    return answer