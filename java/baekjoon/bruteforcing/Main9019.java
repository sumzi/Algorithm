package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main9019 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[] visited;
        int t = Integer.parseInt(br.readLine());
        int nx;
        for (int i = 0; i < t; i++) {
            visited = new boolean[10000];
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited[a] = true;
            Queue<String[]> q = new LinkedList<>();
            q.add(new String[] { String.valueOf(a), "" });
            while (!q.isEmpty()) {
                String[] tmp = q.poll();
                int x = Integer.parseInt(tmp[0]);
                String y = tmp[1];
                if (x == b) {
                    System.out.println(y);
                    break;
                }
                nx = (x * 2) % 10000;
                if (!visited[nx]) {
                    visited[nx] = true;
                    q.add(new String[] { String.valueOf(nx), y + 'D' });
                }
                nx = x != 0 ? x - 1 : 9999;
                if (!visited[nx]) {
                    visited[nx] = true;
                    q.add(new String[] { String.valueOf(nx), y + 'S' });
                }
                nx = (x % 1000) * 10 + x / 1000;
                if (!visited[nx]) {
                    visited[nx] = true;
                    q.add(new String[] { String.valueOf(nx), y + 'L' });
                }
                nx = (x % 10) * 1000 + x / 10;
                if (!visited[nx]) {
                    visited[nx] = true;
                    q.add(new String[] { String.valueOf(nx), y + 'R' });
                }
            }
        }
    }
}