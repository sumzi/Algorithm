package baekjoon.dp;

import java.util.Scanner;

public class Main2240 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int w = sc.nextInt();
        int[] arr = new int[t + 1];
        for (int i = 1; i < t + 1; i++) {
            arr[i] = sc.nextInt();
        }
        int[][][] dp = new int[3][t + 1][w + 2];
        for (int i = 1; i < t + 1; i++) {
            for (int j = 1; j < w + 2; j++) {
                if (arr[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
                } else {
                    if (i == 1 && j == 1)
                        continue;
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]) + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < w + 2; i++) {
            ans = Math.max(ans, Math.max(dp[1][t][i], dp[2][t][i]));
        }
        System.out.println(ans);
    }
}
