package baekjoon;

import java.util.*;

public class Main3067 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int j = 0; j < n; j++) {
                for (int k = arr[j]; k < m + 1; k++) {
                    dp[k] += dp[k - arr[j]];
                }
            }
            System.out.println(dp[m]);
        }
    }
}