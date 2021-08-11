package baekjoon;

import java.util.*;
import java.io.*;

public class Main2636 {
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int n, m, ans1, ans2;
    static int[][] arr;
    static boolean[][] visited;

    public static int bfs() {
        int cnt = 0;
        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (arr[nx][ny] == 0) {
                        q.add(new int[] { nx, ny });
                    } else {
                        cnt++;
                        arr[nx][ny] = 0;
                    }
                }
            }
        }
        return cnt;
    }

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
        while (true) {
            int tmp = bfs();
            if (tmp != 0) {
                ans1++;
                ans2 = tmp;
            } else {
                System.out.println(ans1);
                System.out.println(ans2);
                return;
            }
        }
    }
}