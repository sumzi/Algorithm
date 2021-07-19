def solution(genres, plays):
    answer = []
    d={}
    n=len(genres)
    for i in range(n):
        x=genres[i]
        if x in d:
            d[x].append(plays[i])
        else:
            d[x]=[plays[i]]
    res=sorted(d.items(), key=(lambda x:sum(x[1])), reverse=True)
    for i in res:
        x=i[1]
        y=sorted(x,reverse=True)
        for j in y[:2]:
            answer.append(plays.index(j))
            plays[plays.index(j)]=0
    return answer