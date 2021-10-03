package baekjoon.graph;

import java.util.*;

public class Main11657 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = Integer.MAX_VALUE;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, max);
        dp[1] = 0;
        ArrayList<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj[a].add(new int[] { b, c });
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int[] x : adj[j]) {
                    if (dp[j] != max && dp[x[0]] > dp[j] + x[1]) {
                        dp[x[0]] = dp[j] + x[1];
                        if (i == n - 1) {
                            flag = true;
                        }
                    }
                }
            }
        }
        if (flag) {
            System.out.println(-1);
        } else {
            for (int i = 2; i < n + 1; i++) {
                System.out.println(dp[i] == max ? -1 : dp[i]);
            }
        }
    }
}