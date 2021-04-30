import heapq

def solution(jobs):
    answer = 0
    cnt=0
    q=[]
    n=len(jobs)
    heapq.heapify(jobs)
    while jobs:
        x,y=jobs[0]
        if x<=cnt:
            heapq.heappop(jobs)
            heapq.heappush(q,[y,x])
            continue
        if q:
            a,b=heapq.heappop(q)
            cnt+=a
            answer+=(cnt-b)
        else:
            cnt+=1
    while q:
        a,b=heapq.heappop(q)
        cnt+=a
        answer+=(cnt-b)
    return answer//n