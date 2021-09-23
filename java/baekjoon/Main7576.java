package baekjoon;

import java.util.*;
import java.io.*;

public class Main7576 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.add(new int[] { i, j, 0 });
                } else if (arr[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println(0);
        } else {
            int[] dx = { 0, 0, -1, 1 };
            int[] dy = { -1, 1, 0, 0 };
            int x = 0, y = 0, d = 0;
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                x = tmp[0];
                y = tmp[1];
                d = tmp[2];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                        if (arr[nx][ny] == 0) {
                            q.add(new int[] { nx, ny, d + 1 });
                            arr[nx][ny] = 1;
                        }
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt == 0 ? d : -1);
        }
    }
}
