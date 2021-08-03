package swea.array2;

import java.util.*;
import java.io.*;

public class Solution1211 {
    static int[] dy = { 0, 0, 1 };
    static int[] dx = { -1, 1, 0 };
    static int n, ans, ans2, tmp;
    static int[][] arr = new int[100][100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            n = Integer.parseInt(br.readLine());
            for (int j = 0; j < 100; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            ans = 0;
            ans2 = 1000;
            for (int j = 0; j < 100; j++) {
                if (arr[0][j] == 1) {
                    tmp = dfs(0, j, 1);
                    if (ans2 > tmp) {
                        ans2 = tmp;
                        ans = j;
                    } else if (ans2 == tmp) {
                        ans = Math.max(j, ans);
                    }

                }
            }
            System.out.printf("#%d %d%n", n, ans);
        }
    }

    public static int dfs(int y, int x, int z) {
        arr[y][x] = 0;
        if (y == 99) {
            return z;
        }
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0 <= ny && ny < 100 && 0 <= nx && nx < 100 && arr[ny][nx] == 1) {
                cnt += dfs(ny, nx, z + 1);
                break;
            }
        }
        arr[y][x] = 1;
        return cnt;
    }
}