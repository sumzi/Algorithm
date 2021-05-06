def solution(brown, yellow):
    answer = []
    arr=[]
    for i in range(1,yellow//2+2):
        tmp=yellow//i
        if yellow%i==0 and tmp>=i:
            arr.append([tmp,i])
    x=(brown-4)//2
    for i,j in arr:
        if i+j == x:
            return [i+2,j+2]