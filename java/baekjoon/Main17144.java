package baekjoon;

import java.util.*;

public class Main17144 {
    static int r, c, t;
    static int[][] arr;
    static int u, d;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void spread() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > 0) {
                    q.add(new int[] { i, j, arr[i][j] });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int z = tmp[2];
            if (z < 5)
                continue;
            int cnt = 0;
            int num = z / 5;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                    if (arr[nx][ny] == -1)
                        continue;

                    arr[nx][ny] += num;
                    cnt++;
                }
            }
            arr[x][y] -= (cnt * num);
        }
    }

    public static void move() {
        for (int i = u - 1; i > 0; i--)
            arr[i][0] = arr[i - 1][0];
        for (int i = 0; i < c - 1; i++)
            arr[0][i] = arr[0][i + 1];
        for (int i = 0; i < u; i++)
            arr[i][c - 1] = arr[i + 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            arr[u][i] = arr[u][i - 1];
        arr[u][1] = 0;
        for (int i = d + 1; i < r - 1; i++)
            arr[i][0] = arr[i + 1][0];
        for (int i = 0; i < c - 1; i++)
            arr[r - 1][i] = arr[r - 1][i + 1];
        for (int i = r - 1; i > d; i--)
            arr[i][c - 1] = arr[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--)
            arr[d][i] = arr[d][i - 1];
        arr[d][1] = 0;
    }

    public static void solve() {
        for (int i = 0; i < t; i++) {
            spread();
            move();
        }
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans += arr[i][j];
            }
        }
        System.out.println(ans + 2);
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == -1) {
                    if (u == 0) {
                        u = i;
                        d = i + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
