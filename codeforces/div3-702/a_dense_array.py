def solve():
    n = int(input())
    A = list(map(int, input().split(' ')))
    ans = 0

    for i in range(n - 1):
        u, v = A[i], A[i + 1]
        if u > v:
            u, v = v, u

        while 2 * u < v:
            u *= 2
            ans += 1

    print(ans)


t = int(input())
for _ in range(t):
    solve()
