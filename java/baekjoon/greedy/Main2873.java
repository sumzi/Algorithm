package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Main2873 {
    static int r, c, a = 0, b = 1;
    static int[][] arr;
    static char[] d = { 'D', 'U', 'L', 'R' };
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static StringBuffer buf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        buf = new StringBuffer();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (r % 2 != 0) {
            char[] dir = { 'R', 'L' };
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c - 1; j++) {
                    buf.append(dir[i % 2]);
                }
                if (i != r - 1) {
                    buf.append('D');
                }
            }
        } else if (c % 2 != 0) {
            char[] dir = { 'D', 'U' };
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < r - 1; j++) {
                    buf.append(dir[i % 2]);
                }
                if (i != c - 1) {
                    buf.append('R');
                }
            }
        } else {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if ((i + j) % 2 != 0) {
                        if (arr[a][b] > arr[i][j]) {
                            a = i;
                            b = j;
                        }
                    }
                }
            }
            arr[a][b] = 0;
            if (a % 2 != 0)
                a--;
            char[] dir = { 'R', 'L' };
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < c - 1; j++) {
                    buf.append(dir[i % 2]);
                }
                buf.append('D');
            }
            dfs(a, 0);
            if (a + 2 < r)
                buf.append('D');
            for (int i = a + 2; i < r; i++) {
                for (int j = 0; j < c - 1; j++) {
                    buf.append(dir[(i + 1) % 2]);
                }
                if (i != r - 1) {
                    buf.append('D');
                }
            }
        }
        System.out.println(buf.toString());
    }

    public static void dfs(int x, int y) {
        arr[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (a <= nx && nx < a + 2 && 0 <= ny && ny < c && arr[nx][ny] != 0) {
                buf.append(d[i]);
                dfs(nx, ny);
                return;
            }
        }
    }
}