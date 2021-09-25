package baekjoon.dp;

import java.util.*;

public class Main2228 {
    static int n, m;
    static int[] sum;
    static int[][] dp;
    static boolean[][] visited;
    static int min = -32768 * 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sum = new int[n + 1];
        dp = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1] + sc.nextInt();
            Arrays.fill(dp[i], min);
        }
        System.out.println(divide(n, m));
    }

    public static int divide(int idx, int cnt) {
        if (cnt == 0)
            return 0;
        if (idx <= 0)
            return min;
        if (visited[idx][cnt])
            return dp[idx][cnt];
        visited[idx][cnt] = true;

        dp[idx][cnt] = divide(idx - 1, cnt);
        for (int i = 1; i <= idx; i++) {
            dp[idx][cnt] = Math.max(dp[idx][cnt], divide(i - 2, cnt - 1) + sum[idx] - sum[i - 1]);
        }
        return dp[idx][cnt];
    }
}
