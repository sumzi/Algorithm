package baekjoon.graph;

import java.util.*;
import java.io.*;

public class Main2056 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n + 1];
        int[] time = new int[n + 1];
        int[] ans = new int[n + 1];
        ArrayList<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int a = 1; a <= n; a++) {
            st = new StringTokenizer(br.readLine());
            time[a] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
            } else if (num > 0) {
                cnt[a] += num;
                for (int i = 0; i < num; i++) {
                    int b = Integer.parseInt(st.nextToken());
                    adj[b].add(a);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                q.add(i);
                ans[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < adj[x].size(); i++) {
                int nx = adj[x].get(i);
                if (cnt[nx] > 0) {
                    ans[nx] = Math.max(ans[nx], ans[x] + time[nx]);
                    if (--cnt[nx] == 0) {
                        q.add(nx);
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, ans[i]);
        }
        System.out.println(res);
    }
}