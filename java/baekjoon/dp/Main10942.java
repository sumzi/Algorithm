package baekjoon.dp;

import java.util.*;
import java.io.*;

public class Main10942 {
    static int n, m;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1][n + 1]; // a~b인덱스 사이 여부
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(go(a, b) + "\n");
        }
        System.out.println(sb);
    }

    public static int go(int a, int b) {
        // 길이가 1일때
        if (a == b)
            return 1;
        // 길이가 2일때
        else if (a + 1 == b) {
            if (arr[a] == arr[b]) {
                return 1;
            } else {
                return 0;
            }
        }
        // 길이가 3일때
        if (dp[a][b] > -1)
            return dp[a][b];
        if (arr[a] == arr[b]) // 양끝의 인덱스가 같다면
            dp[a][b] = go(a + 1, b - 1);
        else // 다르다면
            dp[a][b] = 0;

        return dp[a][b];
    }
}
