def solution(record):
    answer = []
    dp={}
    idx=[]
    for i in record:
        tmp=list(i.strip().split())
        if tmp[0]=='Enter':
            dp[tmp[1]]=tmp[2]
            idx.append([tmp[0],tmp[1]])
        elif tmp[0]=='Change':
            dp[tmp[1]]=tmp[2]
        elif tmp[0]=='Leave':
            idx.append([tmp[0],tmp[1]])
    for a,b in idx:
        if a=='Enter':
            answer.append(dp[b]+'님이 들어왔습니다.')
        elif a=='Leave':
            answer.append(dp[b]+'님이 나갔습니다.')
    return answer