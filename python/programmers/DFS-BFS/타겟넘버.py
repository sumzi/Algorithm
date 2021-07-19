answer=0
def dfs(x, cnt,dp,y):
    global answer
    if cnt == len(dp):
        if x == y:
            answer += 1
        return
    dfs(x+dp[cnt], cnt+1,dp,y)
    dfs(x-dp[cnt], cnt+1,dp,y)
    return

def solution(numbers, target):
    dfs(0, 0,numbers,target)
    return answer