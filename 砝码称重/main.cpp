#include <stdio.h>
#include <math.h>
#define N 105
#define MAX_W 100005

// 注意数组不能开在函数里面，否则会栈溢出
int dp[N][MAX_W] = {0};

int main()
{

    int n;
    scanf("%d", &n);
    // 读入砝码质量
    int a[N];
    for (int i = 1; i <= n; i++)
    {
        scanf("%d", &a[i]);
    }

    dp[0][0] = 1;
    int total_sum = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 0; j <= total_sum; j++)
        {
            if (dp[i - 1][j] == 1)
            {
                dp[i][j] = 1;
                dp[i][j + a[i]] = 1;
                dp[i][abs(j - a[i])] = 1;
            }
        }
        total_sum += a[i - 1];
    }
    int sum = 0;
    for (int i = 0; i <= total_sum; i++)
    {
        if (dp[n][i] == 1)
        {
            sum++;
        }
    }
    printf("%d", sum - 1);
    return 0;
}