package swea;

import java.util.*;

public class Solution5643 {
    static int n, m;
    static ArrayList<Integer>[] list, list2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnt;
        Queue<Integer> q = new LinkedList<>();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            cnt = new int[n + 1];
            list = new ArrayList[n + 1];
            list2 = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                list[j] = new ArrayList<>();
                list2[j] = new ArrayList<>();
            }

            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                list[a].add(b);
                list2[b].add(a);
                cnt[b]++;
            }

            for (int j = 1; j <= n; j++) {
                if (cnt[j] == 0) {
                    q.add(j);
                }
            }
            int ans = 0;
            int a = n;
            while (!q.isEmpty()) {
                int size = q.size();
                if (size == 1) {
                    if (a + bfs(q.peek()) == n)
                        ans++;
                }
                for (int j = 0; j < size; j++) {
                    int x = q.poll();
                    a--;
                    for (int k = 0; k < list[x].size(); k++) {
                        int nx = list[x].get(k);
                        if (--cnt[nx] == 0) {
                            q.add(nx);
                        }
                    }
                }
            }
            System.out.println("#" + i + " " + ans);
        }
    }

    public static int bfs(int x) {
        int res = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> qq = new LinkedList<>();
        qq.add(x);
        visited[x] = true;
        while (!qq.isEmpty()) {
            x = qq.poll();
            res++;
            for (int i = 0; i < list2[x].size(); i++) {
                int nx = list2[x].get(i);
                if (!visited[nx]) {
                    visited[nx] = true;
                    qq.add(nx);
                }
            }
        }
        return res - 1;
    }
}