package baekjoon.graph;

/**
 * 최악의 경우를 대비하여 n-1번 돌리는 것
 */
import java.util.*;

public class Main1865 {
    static int tc, n, m, w, s, e, t;
    static int max = Integer.MAX_VALUE;
    static int[] dp;
    static ArrayList<int[]>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            w = sc.nextInt();
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            dp[1] = 0;
            adj = new ArrayList[n + 1];
            for (int j = 1; j < n + 1; j++) {
                adj[j] = new ArrayList<>();
            }

            for (int j = 0; j < m; j++) {
                s = sc.nextInt();
                e = sc.nextInt();
                t = sc.nextInt();
                adj[s].add(new int[] { e, t });
                adj[e].add(new int[] { s, t });
            }
            for (int j = 0; j < w; j++) {
                s = sc.nextInt();
                e = sc.nextInt();
                t = sc.nextInt();
                adj[s].add(new int[] { e, -t });
            }

            if (bellmanFord()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean bellmanFord() {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int[] x : adj[j]) {
                    if (dp[x[0]] > dp[j] + x[1]) {
                        dp[x[0]] = dp[j] + x[1];
                        if (i == n - 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
