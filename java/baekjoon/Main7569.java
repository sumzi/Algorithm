package baekjoon;

import java.util.*;

public class Main7569 {
    static int m, n, h, ans = 0;
    static boolean flag, check = false;
    static int[][][] box;
    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        box = new int[h][n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = sc.nextInt();
                    if (box[i][j][k] == 1) {
                        q.add(new int[] { i, j, k });
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int cnt = q.size();
            flag = false;
            for (int i = 0; i < cnt; i++) {
                int[] tmp = q.poll();
                for (int j = 0; j < 6; j++) {
                    int nx = tmp[1] + dx[j];
                    int ny = tmp[2] + dy[j];
                    int nz = tmp[0] + dz[j];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && 0 <= nz && nz < h && box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = 1;
                        q.add(new int[] { nz, nx, ny });
                        flag = true;
                    }
                }
            }
            if (flag) {
                ans += 1;
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        check = true;
                        break;
                    }
                }
            }
        }
        if (check) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
