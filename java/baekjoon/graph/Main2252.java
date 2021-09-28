package baekjoon.graph;

import java.util.*;

public class Main2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cnt = new int[n + 1];
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            cnt[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (cnt[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");

            for (int i = 0; i < adj[x].size(); i++) {
                int nx = adj[x].get(i);
                if (cnt[nx] > 0) {
                    if (--cnt[nx] == 0) {
                        q.add(nx);
                    }
                }
            }
        }
    }
}
