# 分析
这题的数据规模为 1 < n < 100, 也就是说，复杂度可以是O(n^3)
复杂度为O3的蓝桥可用算法包括floyd和dp, 这题明显是用dp
既然是dp就要找到递推关系，也叫状态转移方程
# 状态转移方程
要求的是方法数，一般来讲，dp数组的值也就是要求的东西
但是在这里，要求的是可以称出多少种不同的重量。由于新加物品可能会和前面的重复，这也有影响
比如，知道第i-1个物品有可以称出k种重量，这k种重量到底是哪些，对于加上第i个物品后称出的
重量也有影响，所以，用可称的重量数作为dp数组的值，是不够的，还要知道这k种重量是哪些

因此，一个列表，里面存放可以称出来的重量,或者dp数组的值应该是0，1，表示这种重量可不可以
称出来。
dp[i][j] = dp[i-1][j] | dp[i-1][abs(j-weight[i])] | dp[i-1][j+weight[i]]
同时已知，dp[0][0] = 1

因此，从不断更新dp数组，可以得到最终的答案