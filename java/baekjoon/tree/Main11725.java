package baekjoon.tree;

import java.util.*;

public class Main11725 {
    static int n;
    static int[] parent;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        parent = new int[n + 1];
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(0, 1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int prev, int cur) {
        for (Integer next : tree[cur]) {
            if (next == prev)
                continue;
            parent[next] = cur;
            dfs(cur, next);
        }
    }
}
