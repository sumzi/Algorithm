package baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main11066 {
    static int[][] dp;
    static int[] sum;
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sum = new int[n + 1];
            dp = new int[n + 1][n + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                sum[j] = sum[j - 1] + Integer.parseInt(st.nextToken());
                Arrays.fill(dp[j], -1);
            }
            System.out.println(add(1, n));
        }
    }

    public static int add(int start, int end) {
        if (start == end)
            return 0;
        if (dp[start][end] > -1)
            return dp[start][end];
        dp[start][end] = max;
        for (int mid = start; mid < end; mid++) {
            dp[start][end] = Math.min(dp[start][end], add(start, mid) + add(mid + 1, end));
        }
        return dp[start][end] += sum[end] - sum[start - 1];
    }
}
