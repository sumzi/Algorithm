import sys
input=sys.stdin.readline

n = 1
while True:
    l, p, v = map(int, input().split())
    if l+p+v == 0:
         break

    m = (v//p)*l
    m+=min(v%p,l)
    print('Case %d: %d' % (n, m))
    n += 1
