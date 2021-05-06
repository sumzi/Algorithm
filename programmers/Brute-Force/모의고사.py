def solution(answers):
    answer = []
    s1=[1, 2, 3, 4, 5]
    s2=[2, 1, 2, 3, 2, 4, 2, 5]
    s3=[3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    dp=[[0,1],[0,2],[0,3]]
    x=0
    for i in answers:
        if s1[x%5]==i:
            dp[0][0]+=1
        if s2[x%8]==i:
            dp[1][0]+=1
        if s3[x%10]==i:
            dp[2][0]+=1
        x+=1
    dp.sort(reverse=True)
    tmp=dp[0][0]
    for i,j in dp:
        if tmp == i:
            answer.append(j)
    answer.sort()
    return answer