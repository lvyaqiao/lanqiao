def get_input():
    n = int(input())
    arr = [[0] * (n + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):
        arr[i][1:] = [int(x) for x in input().split()]
    return n ,arr

def solution1():
    n, arr = get_input()
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            arr[i][j] += max(arr[i - 1][j], arr[i][j - 1])
    print(arr[n][n])
    
def solution2():
    n, arr = get_input()
    dp = [[0] * (n + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j]
    print(dp[n][n])
    
solution1()