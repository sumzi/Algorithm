package baekjoon.dp;

import java.util.*;

public class Main5557 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n - 1][21];
        int x = sc.nextInt();
        dp[0][x] = 1;
        for (int i = 1; i < n - 1; i++) {
            x = sc.nextInt();
            for (int j = 0; j < 21; j++) {
                if (dp[i - 1][j] > 0) {
                    if (0 <= j - x)
                        dp[i][j - x] += dp[i - 1][j];
                    if (j + x < 21)
                        dp[i][j + x] += dp[i - 1][j];
                }
            }
        }
        int y = sc.nextInt();
        System.out.println(dp[n - 2][y]);
    }
}
