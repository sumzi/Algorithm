def solution(phone_book):
    answer = True
    phone_book.sort()
    n=len(phone_book)
    for i in range(n-1):
        a=phone_book[i]
        b=phone_book[i+1][:len(a)]
        if a==b:
            return False
    return answer