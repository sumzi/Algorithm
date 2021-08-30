package baekjoon.Brute_Force;

import java.util.*;
import java.io.*;

public class Main10971 {
    static int n, ans = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(i, 0, i, 0);
        }
        System.out.println(ans);
    }

    public static void dfs(int start, int cnt, int cur, int cost) {
        if (cnt == n - 1) {
            if (map[cur][start] != 0) {
                ans = Math.min(ans, cost + map[cur][start]);
            }
            return;
        }
        visited[cur] = true;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            if (map[cur][i] != 0 && cost + map[cur][i] < ans) {
                dfs(start, cnt + 1, i, cost + map[cur][i]);
            }
        }
        visited[cur] = false;
    }
}