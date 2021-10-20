package baekjoon.tree;

import java.util.*;

public class Main1068 {
    static int n, x, ans;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            if (m == -1)
                root = i;
            else
                tree[m].add(i);
        }
        x = sc.nextInt();
        if (root == x) {
            System.out.println(0);
        } else {
            solution(root);
            System.out.println(ans);
        }
    }

    public static void solution(int cur) {
        int cnt = 0;
        for (Integer next : tree[cur]) {
            if (next == x)
                continue;
            cnt++;
            solution(next);
        }
        if (cnt == 0)
            ans++;
    }
}