package baekjoon;

import java.util.*;
import java.io.*;

public class Main17070 {
    static int[][] arr;
    static int n;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(dfs(0, 1, 0));
    }

    public static boolean check(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n) {
            return true;
        }
        return false;
    }

    public static int dfs(int x, int y, int z) {
        if (x == n - 1 && y == n - 1)
            return 1;
        if (dp[x][y][z] > -1) {
            return dp[x][y][z];
        }
        int cnt = 0;
        if (z != 1 && check(x, y + 1) && arr[x][y + 1] == 0)
            cnt += dfs(x, y + 1, 0);
        if (z != 0 && check(x + 1, y) && arr[x + 1][y] == 0)
            cnt += dfs(x + 1, y, 1);
        if (check(x + 1, y + 1) && arr[x + 1][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x][y + 1] == 0)
            cnt += dfs(x + 1, y + 1, 2);
        return dp[x][y][z] = cnt;
    }
}