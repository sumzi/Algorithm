package baekjoon;

import java.util.*;

public class Main1012 {
    static int t, m, n, k, x, y, ans = 0;
    static int[][] arr;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int a = 0; a < t; a++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int[m][n];
            ans=0;
            for (int i = 0; i < k; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                arr[x][y] = 1;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        dfs(i, j);
                        ans += 1;
                    }
                }
            }
            System.out.println(ans);    
        }
        
    }

    public static void dfs(int x, int y) {
        arr[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < m && 0 <= ny && ny < n && arr[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
