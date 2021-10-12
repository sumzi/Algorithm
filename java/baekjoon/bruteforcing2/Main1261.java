package baekjoon.bruteforcing2;

import java.util.*;

public class Main1261 {
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int n, m;
    static int[][] arr, dp;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
                dp[i][j] = INF;
            }
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        dp[0][0] = 0;
        q.add(new int[] { 0, 0, 0 });
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int w = tmp[2];
            if (w > dp[x][y])
                continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (dp[nx][ny] > w + arr[nx][ny]) {
                        dp[nx][ny] = w + arr[nx][ny];
                        q.add(new int[] { nx, ny, dp[nx][ny] });
                    }
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
