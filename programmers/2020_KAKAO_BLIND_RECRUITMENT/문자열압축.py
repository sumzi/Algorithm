def solution(s):
    answer = len(s)
    n=len(s)
    
    for i in range(1,n//2+1):
        l=0
        r=i
        tmp=''
        while l<n:
            if s[l:l+i]==s[r:r+i]:
                  r+=i
            else:
                if ((r-l)//i)>1:
                    tmp+=(str((r-l)//i)+s[l:l+i])
                    l=r
                else:
                    tmp+=(s[l:l+i])
                l=r
                r=l+i
        answer=min(answer,len(tmp))
    return answer