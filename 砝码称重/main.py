def get_input1():
    n = int(input())
    arr = [int(i) for i in input().split()]
    return n, arr


def solution1():
    n, arr = get_input1()
    # dp[i] 是一个集合表示前i个砝码有哪些称法
    s = {arr[0]}
    for i in range(1, n):
        # 新加的砝码的重量
        new_val = arr[i]
        # 之前可以称出的重量
        lst = list(s)
        # 用新砝码可以直接称出的重量
        s.add(new_val)
        # 注意，一定不要迭代一个正在变化的东西，比如dp这个集合
        # 这里添加和老砝码组合可以称出的重量
        for item in lst:
            s.add(item + new_val)
            s.add(abs(item - new_val))

    # 这里是一个坑，不可以称出0
    result = len(s) - 1 if 0 in s else len(s)
    print(result)


def get_input2():
    n = int(input())
    # 这里arr[i] 表示第i个砝码的重量
    arr = [0] + [int(i) for i in input().split()]
    return n, arr


def solution2():
    n, arr = get_input2()
    dp = [[0] * 100005 for i in range(n + 1)]

    # dp[i][j] 表示前i个砝码是否可以称出重量j
    # 这里，不拿砝码只能称出重量0
    dp[0][0] = 1
    total_sum = 0
    for i in range(1, n + 1):
        for j in range(0, total_sum + 1):
            if dp[i - 1][j]:
                # 加上i号砝码，可以称出j + arr[i]，j - arr[i]的绝对值，还有原来的j
                dp[i][j] = 1
                dp[i][j + arr[i]] = 1
                dp[i][abs(j - arr[i])] = 1

        # 更新总重量
        total_sum += arr[i]

    last = dp[n]
    print(sum(last) - 1)
    get
solution2()
