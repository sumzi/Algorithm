package baekjoon;

import java.util.*;
import java.io.*;

public class Main17070_2 {
    static int[][] arr;
    static int n;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 1)
                    continue;
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j][2];
            }
        }
        System.out.println();
    }
}