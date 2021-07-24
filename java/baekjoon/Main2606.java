package baekjoon;

import java.util.*;

public class Main2606 {
    static int n, m, ans = 0;
    static int[] v = new int[101];
    static int[][] adj = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = adj[b][a] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        v[1] = 1;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i < n + 1; i++) {
                if (adj[x][i] == 1 && v[i] == 0) {
                    v[i] = 1;
                    q.add(i);
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
