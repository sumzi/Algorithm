import heapq
def solution(operations):
    q=[]
    for i in operations:
        n,m=i.split()
        if n=='I':
            heapq.heappush(q,int(m))
        else:
            if q:
                if m=='1':
                    q.remove(max(q))
                else:
                    heapq.heappop(q)
    if len(q)==0:
        return [0,0]
    else:
        x=max(q)
        y=heapq.heappop(q)
        return [x,y]