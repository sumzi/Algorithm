package swea;

import java.util.*;

public class Solution1249 {
    static int n, ans;
    static int max = Integer.MAX_VALUE;
    static int[][] arr, dp;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            arr = new int[n][n];
            dp = new int[n][n];
            visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                String s = sc.next();
                for (int k = 0; k < n; k++) {
                    arr[j][k] = s.charAt(k) - '0';
                    dp[j][k] = max;
                }
            }
            ans = max;
            dp[0][0] = 0;
            visited[0][0] = true;
            dfs(0, 0);
            System.out.println("#" + i + " " + ans);
            // System.out.println("#" + i + " " + bfs());
        }
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        dp[0][0] = 0;
        visited[0][0] = true;
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            if (x == n - 1 && y == n - 1) {
                ans = Math.min(ans, dp[x][y]);
            }

            if (ans <= dp[x][y])
                continue;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visited[nx][ny] || dp[nx][ny] > dp[x][y] + arr[nx][ny]) {
                        visited[nx][ny] = true;
                        dp[nx][ny] = dp[x][y] + arr[nx][ny];
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
        return ans;
    }

    public static void dfs(int x, int y) {
        if (x == n - 1 && y == n - 1) {
            ans = Math.min(ans, dp[x][y]);
            return;
        }
        if (ans <= dp[x][y])
            return;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (!visited[nx][ny] || dp[nx][ny] > dp[x][y] + arr[nx][ny]) {
                    visited[nx][ny] = true;
                    dp[nx][ny] = dp[x][y] + arr[nx][ny];
                    dfs(nx, ny);
                }
            }
        }
    }
}