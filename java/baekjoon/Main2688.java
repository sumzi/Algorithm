package baekjoon;

import java.util.*;

public class Main2688 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[][] dp = new long[65][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i < 65; i++) {
            dp[i][0] = 1;
        }
        for (int i = 2; i < 65; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long ans = 0;
            for (int j = 0; j < 10; j++) {
                ans += dp[n][j];
            }
            System.out.println(ans);
        }
    }
}