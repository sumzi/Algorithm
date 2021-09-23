package baekjoon.dp;

import java.util.*;

public class Main2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int INF = 100001;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            for (int j = x; j < k + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - x] + 1);
            }
        }
        System.out.println(dp[k] != INF ? dp[k] : -1);
    }
}
