package baekjoon.dp;

import java.util.*;

public class Main2096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        int[][][] dp = new int[2][3][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
                if (i == 0) {
                    dp[0][j][0] = dp[0][j][1] = arr[i][j];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[1][j][0] = Math.max(dp[0][j][0], dp[0][j + 1][0]) + arr[i][j];
                    dp[1][j][1] = Math.min(dp[0][j][1], dp[0][j + 1][1]) + arr[i][j];
                } else if (j == 1) {
                    dp[1][j][0] = Math.max(dp[0][j][0], Math.max(dp[0][j - 1][0], dp[0][j + 1][0])) + arr[i][j];
                    dp[1][j][1] = Math.min(dp[0][j][1], Math.min(dp[0][j - 1][1], dp[0][j + 1][1])) + arr[i][j];
                } else {
                    dp[1][j][0] = Math.max(dp[0][j][0], dp[0][j - 1][0]) + arr[i][j];
                    dp[1][j][1] = Math.min(dp[0][j][1], dp[0][j - 1][1]) + arr[i][j];
                }
            }
            for (int k = 0; k < 3; k++) {
                dp[0][k][0] = dp[1][k][0];
                dp[0][k][1] = dp[1][k][1];
            }
        }
        System.out.print(Math.max(Math.max(dp[0][0][0], dp[0][1][0]), dp[0][2][0]) + " ");
        System.out.println(Math.min(Math.min(dp[0][0][1], dp[0][1][1]), dp[0][2][1]));

    }
}
