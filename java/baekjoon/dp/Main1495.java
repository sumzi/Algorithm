package baekjoon.dp;

import java.util.*;

public class Main1495 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][s] = 1;
        int ans = -1;
        for (int i = 1; i < n + 1; i++) {
            int x = sc.nextInt();
            for (int j = 0; j < m + 1; j++) {
                if (dp[i - 1][j] == 1) {
                    if (0 <= j - x)
                        dp[i][j - x] = 1;
                    if (j + x <= m)
                        dp[i][j + x] = 1;
                }
            }
        }
        for (int i = 0; i < m + 1; i++) {
            if (dp[n][i] == 1)
                ans = i;
        }
        System.out.println(ans);
    }
}
