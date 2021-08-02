package baekjoon;

import java.io.*;
import java.util.*;

public class Main2468 {
    static int n, num = 0, ans = 1;
    static int[][] arr;
    static int[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void dfs(int x, int y, int z) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == 0 && arr[nx][ny] > z) {
                dfs(nx, ny, z);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                num = Math.max(num, arr[i][j]);
            }
        }
        for (int i = 1; i < num + 1; i++) {
            visited = new int[n][n];
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (visited[j][k] == 0 && arr[j][k] > i) {
                        dfs(j, k, i);
                        tmp++;
                    }
                }
            }
            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }
}
