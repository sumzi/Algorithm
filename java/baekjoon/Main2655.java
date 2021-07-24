package baekjoon;

import java.util.*;
import java.io.*;

public class Main2655 {
    static int n;
    static int[][] room;
    static int[][] dp;
    static int dx[] = { 0, 0, -1, 1 };
    static int dy[] = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        room = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(s[j]) == 1) {
                    room[i][j] = 0;
                } else {
                    room[i][j] = 1;
                }
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = room[0][0];
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] x = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x[0] + dx[i];
                int ny = x[1] + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    int y = dp[x[0]][x[1]];
                    if (room[nx][ny] + y < dp[nx][ny]) {
                        dp[nx][ny] = room[nx][ny] + y;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);

    }
}
