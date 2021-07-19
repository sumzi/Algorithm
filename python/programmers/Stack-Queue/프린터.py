import heapq
from collections import deque

def solution(priorities, location):
    answer = 0
    q=deque()
    p=[]
    n=len(priorities)
    for i in range(n):
        q.append([i,priorities[i]])
        heapq.heappush(p,-priorities[i])
    while q:
        x,y=q.popleft()
        if y == -p[0]:
            heapq.heappop(p)
            answer+=1
            if x==location:
                return answer
        else:
            q.append([x,y])
    return answer