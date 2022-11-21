#include <stdio.h>
#include <vector>

using namespace std;
int arr[1002][1002] = {0};

int main()
{
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            scanf("%d", &arr[i][j]);
        }
    }

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            arr[i][j] = max(arr[i - 1][j], arr[i][j - 1]) + arr[i][j];
        }
    }
    printf("%d", arr[n][n]);
}