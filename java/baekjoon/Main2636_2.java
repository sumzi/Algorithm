package baekjoon;

import java.util.*;
import java.io.*;

public class Main2636_2 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int cnt = 0;
        while (true) {
            int x = bfs();
            if (x == 0)
                break;
            cnt = x;
            time++;
        }
        System.out.println(time);
        System.out.println(cnt);
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        visited = new boolean[n][m];
        visited[0][0] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (arr[nx][ny] == 1) {
                        cnt++;
                        arr[nx][ny] = 0;
                    } else {
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
        return cnt;
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        if (arr[x][y] == 1) {
            arr[x][y] = 0;
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                cnt += dfs(nx, ny);
            }
        }
        return cnt;
    }
}
