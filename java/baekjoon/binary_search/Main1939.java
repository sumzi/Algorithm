package baekjoon.binary_search;

import java.util.*;
import java.io.*;

public class Main1939 {
    static class Node {
        int no;
        int weight;

        Node(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<Node>());
        }
        long l = 1;
        long r = 0;
        long ans = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
            r = Math.max(r, c);
        }
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        boolean[] visited;
        Queue<Integer> q = new LinkedList<>();

        while (l <= r) {
            long mid = (l + r) / 2;
            q.clear();
            boolean flag = false;
            visited = new boolean[n + 1];
            visited[x] = true;
            q.add(x);

            while (!q.isEmpty()) {
                int cur = q.poll();
                if (cur == y) {
                    flag = true;
                    break;
                }
                for (Node next : list.get(cur)) {
                    if (!visited[next.no] && next.weight >= mid) {
                        q.offer(next.no);
                        visited[next.no] = true;
                    }
                }
            }

            if (flag) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
