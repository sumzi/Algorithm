package baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main1890 {
    static int n;
    static int[][] arr;
    static long[][] dp;
    static int[] dx = { 0, 1 };
    static int[] dy = { 1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(go(0, 0));
    }

    public static long go(int x, int y) {
        if (x == n - 1 && y == n - 1)
            return 1;
        if (arr[x][y] == 0)
            return 0;
        if (dp[x][y] > 0)
            return dp[x][y];
        dp[x][y] = 0;
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * arr[x][y];
            int ny = y + dy[i] * arr[x][y];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                dp[x][y] += go(nx, ny);
            }
        }
        return dp[x][y];
    }
}
