package swea;

import java.util.*;
import java.io.*;

public class Solution3307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] a;
        int[] dp;
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            a = new int[n];
            dp = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            for (int j = 0; j < n; j++) {
                dp[j] = 1;
                for (int k = 0; k < j; k++) {
                    if (a[k] < a[j]) {
                        dp[j] = Math.max(dp[j], dp[k] + 1);
                    }
                }
                ans = Math.max(ans, dp[j]);
            }
            System.out.println("#" + i + " " + ans);
        }
    }
}