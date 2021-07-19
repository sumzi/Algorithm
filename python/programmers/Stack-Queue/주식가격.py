def solution(prices):
    n=len(prices)
    answer = [0]*n
    for i in range(n-1):
        for j in range(i,n-1):
            if prices[i]<=prices[j]:
                answer[i]+=1
            else:
                break
    return answer