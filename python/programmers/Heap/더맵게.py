import heapq
def solution(scoville, K):
    answer = 0
    q=[]
    for i in scoville:
        heapq.heappush(q,i)
    while q:
        x=heapq.heappop(q)
        if x>=K:
            return answer
        if not q:
            return -1
        a=heapq.heappop(q)
        tmp=x+(a*2)
        answer+=1
        heapq.heappush(q,tmp)
    return -1