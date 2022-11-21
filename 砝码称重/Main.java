import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        int[][] dp = new int[n + 1][100002];

        int total_sum = 0;
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            total_sum += a[i];
            for (int j = 0; j <= total_sum; j++) {
                if (dp[i - 1][j] == 1) {
                    dp[i][j] = 1;
                    dp[i][Math.abs(j - a[i])] = 1;
                    dp[i][j + a[i]] = 1;
                }
            }
        }
        int[] last = dp[n];
        int sum_of_last = 0;
        for (int i = 0; i < last.length; i++) {
            if (last[i] == 1) {
                sum_of_last++;
            }
        }
        System.out.println(sum_of_last - 1);
    }
}