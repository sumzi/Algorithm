from collections import deque
def solution(board, moves):
    answer = 0
    dolls=[deque() for i in range(len(board))]
    for i in board:
        for j in range(len(i)):
            if i[j]!=0:
                dolls[j].append(i[j])
    q=deque()
    for i in moves:
        if dolls[i-1]:
            x=dolls[i-1].popleft()
            if not q:
                q.append(x)
            else:
                if q[-1]==x:
                    q.pop()
                    answer+=2
                else:
                    q.append(x)
    return answer