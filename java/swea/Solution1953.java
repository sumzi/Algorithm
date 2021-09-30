package swea;

import java.util.*;

public class Solution1953 {
    static int[][] type = { {}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 0, 3 }, { 0, 1 }, { 1, 2 } };
    static int n, m, r, c, l;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            l = sc.nextInt();
            map = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    map[j][k] = sc.nextInt();
                }
            }

            System.out.println("#" + i + " " + bfs());
        }
    }

    public static boolean check(int a, int b) {
        for (int i = 0; i < type[a].length; i++) {
            if (type[a][i] == b)
                return true;
        }
        return false;
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        visited[r][c] = true;
        int ans = 0;
        q.add(new int[] { r, c, 0 });
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int z = tmp[2];
            if (z == l)
                break;
            ans++;
            for (int i = 0; i < type[map[x][y]].length; i++) {
                int a = (type[map[x][y]][i] + 2) % 4;
                int nx = x + dx[a];
                int ny = y + dy[a];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] > 0) {
                        if (check(map[nx][ny], a)) {
                            visited[nx][ny] = true;
                            q.add(new int[] { nx, ny, z + 1 });
                        }
                    }
                }
            }
        }
        return ans;
    }
}