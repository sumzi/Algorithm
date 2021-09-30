package swea;

import java.util.*;

public class Solution1949 {
    static int n, k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            k = sc.nextInt();
            map = new int[n][n];
            int max = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = sc.nextInt();
                    max = Math.max(max, map[j][k]);
                }
            }
            int ans = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] == max) {
                        visited = new boolean[n][n];
                        ans = Math.max(ans, dfs(j, k, 0));
                    }
                }
            }
            System.out.println("#" + i + " " + ans);
        }
    }

    public static int dfs(int x, int y, int z) {
        visited[x][y] = true;
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
                if (map[x][y] > map[nx][ny]) {
                    cnt = Math.max(cnt, dfs(nx, ny, z));
                } else if (z == 0) {
                    if (map[nx][ny] - map[x][y] + 1 <= k) {
                        if (map[x][y] - 1 < 0)
                            continue;
                        int tmp = map[nx][ny];
                        map[nx][ny] = map[x][y] - 1;
                        cnt = Math.max(cnt, dfs(nx, ny, 1));
                        map[nx][ny] = tmp;
                    }
                }
            }
        }
        visited[x][y] = false;
        return cnt + 1;
    }
}
