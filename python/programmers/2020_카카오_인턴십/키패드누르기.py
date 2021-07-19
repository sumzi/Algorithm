def solution(numbers, hand):
    answer = ''
    num={
        1:[0,0],
        2:[0,1],
        3:[0,2],
        4:[1,0],
        5:[1,1],
        6:[1,2],
        7:[2,0],
        8:[2,1],
        9:[2,2],
        0:[3,1],
        '*':[3,0],
        '#':[3,0]
    }
    l='*'
    r='#'
    for i in numbers:
        if i==1 or i==4 or i==7:
            answer+='L'
            l=i
        elif i==3 or i==6 or i==9:
            answer+='R'
            r=i
        else:
            a=num[i]
            b=num[l]
            c=num[r]
            x=abs(a[0]-b[0])+abs(a[1]-b[1])
            y=abs(a[0]-c[0])+abs(a[1]-c[1])
            if x==y:
                if hand=='left':
                    answer+='L'
                    l=i
                else:
                    answer+='R'
                    r=i
            elif x<y:
                answer+='L'
                l=i
            else:
                answer+='R'
                r=i
    return answer