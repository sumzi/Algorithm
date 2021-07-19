n, m, k = map(int, input().split())
team = min(n//2, m)
tmp = (n-(team*2)+(m-team))

if tmp < k:
    k -= tmp
    while k > 0:
        team -= 1
        k -= 3

print(team)