from collections import deque
def bfs():
    q=deque()
    q.append([n,0])
    t=0
    cnt=1
    while q:
        s=[]
        for i in range(cnt):
            tmp=q.popleft()
            x=list(map(int,list(str(tmp[0]))))
            for j in range(len(x)):
                for l in range(j+1,len(x)):
                    x[j],x[l]=x[l],x[j]
                    if x[0]!=0:   
                        a=int(''.join(map(str,x)))
                        if a not in s:
                            s.append(a)
                            q.append([a,tmp[1]+1])
                    x[j],x[l]=x[l],x[j]
        cnt=len(q)
        t+=1
        if t==k:
            if s:
                print(max(s))
            else:
                print(-1)
            return
    print(-1)

n,k=map(int,input().split())
bfs()