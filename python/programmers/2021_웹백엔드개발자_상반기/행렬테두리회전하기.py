from collections import deque
def solution(rows, columns, queries):
    answer = []
    dp=[[0]*(columns+1) for i in range(rows+1)]
    cnt=1
    for i in range(1,rows+1):
        for j in range(1,columns+1):
            dp[i][j]=cnt
            cnt+=1
    for x1,y1,x2,y2 in queries:
        q=deque()
        x=x1
        y=y1
        num=dp[x+1][y]
        q.append(dp[x+1][y])
        for i in range(y1,y2):
            tmp=dp[x][i]
            num=min(num,tmp)
            q.append(tmp)
            dp[x][i]=q.popleft()
            y+=1
        for i in range(x1,x2):
            tmp=dp[i][y]
            num=min(num,tmp)
            q.append(tmp)
            dp[i][y]=q.popleft()
            x+=1
        for i in range(y2,y1,-1):
            tmp=dp[x][i]
            num=min(num,tmp)
            q.append(tmp)
            dp[x][i]=q.popleft()
            y-=1
        for i in range(x2,x1,-1):
            tmp=dp[i][y]
            num=min(num,tmp)
            q.append(tmp)
            dp[i][y]=q.popleft()
            x-=1
        answer.append(num)
    return answer