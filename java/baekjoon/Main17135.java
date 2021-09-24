package baekjoon;

import java.util.*;
import java.io.*;

public class Main17135 {
    static int n, m, d, ans = 0;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] archer = new int[3];
        for (int i = 0; i < m - 2; i++) {
            archer[0] = i;
            for (int j = i + 1; j < m - 1; j++) {
                archer[1] = j;
                for (int k = j + 1; k < m; k++) {
                    archer[2] = k;
                    attack(archer);
                }
            }
        }
        System.out.println(ans);
    }

    static int[] dx = { 0, -1, 0 };
    static int[] dy = { -1, 0, 1 };
    static Queue<int[]> q = new LinkedList<>();
    static int[][] a;
    static int cnt = 0;

    public static void bfs(int nn) {
        boolean[][] visited = new boolean[n][m];

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int z = tmp[2];
            if (z > d)
                return;
            if (x <= nn && a[x][y] != -1 && arr[x][y] == 1) {
                a[x][y]++;
                return;
            }
            for (int k = 0; k < 3; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx <= nn && 0 <= ny && ny < m) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny, z + 1 });
                    }
                }
            }
        }
    }

    public static void attack(int[] archer) {
        a = new int[n][m];
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                q.clear();
                q.add(new int[] { i + 1, archer[j], 0 });
                bfs(i);
            }

            for (int j = 0; j < i + 1; j++) {
                for (int k = 0; k < m; k++) {
                    if (a[j][k] > 0) {
                        cnt++;
                        a[j][k] = -1;
                    }
                }
            }

        }
        ans = Math.max(ans, cnt);
    }
}