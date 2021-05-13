def solution(enroll, referral, seller, amount):
    answer = []
    n=len(enroll)
    m=len(seller)
    adj={'-':[]}
    cost={'-':0}
    for i in range(n):   
        cost[enroll[i]]=0
        adj[enroll[i]]=referral[i]
    def dfs(x,y):
        tmp=y//10
        cost[x]+=(y-tmp)
        if x=="-":
            return
        dfs(adj[x],tmp)

    for i in range(m):
        dfs(seller[i],amount[i]*100)   
    for i in enroll:
        answer.append(cost[i])
    return answer