def check(x):
    s=[]
    for i in x:
        if i=='[' or i=='(' or i=='{':
            s.append(i)
        elif not s:
            return 0
        elif i==']':
            if s[-1]=='[':
                s.pop()
            else:
                return 0
        elif i==')':
            if s[-1]=='(':
                s.pop()
            else:
                return 0
        elif i=='}':
            if s[-1]=='{':
                s.pop()
            else:
                return 0
    if s:
        return 0
    return 1

def solution(s):
    answer = 0
    for i in range(len(s)):
        x=s[i:]+s[:i]
        answer+=check(x)
    return answer

print(solution("[](){}"))