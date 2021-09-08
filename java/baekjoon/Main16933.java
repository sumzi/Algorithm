package baekjoon;

import java.util.*;
import java.io.*;

public class Main16933 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int z;
        int cnt;
        int time;

        public Node(int x, int y, int z, int cnt, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        boolean[][][] visited = new boolean[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0, 0, 0));// x,y,z,time
        visited[0][0][0] = true;
        int ans = -1;
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            int z = tmp.z;
            int cnt = tmp.cnt;
            int time = tmp.time;
            if (x == n - 1 && y == m - 1) {
                ans = cnt + 1;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == '0' && !visited[nx][ny][z]) {
                        q.add(new Node(nx, ny, z, cnt + 1, (time == 0 ? 1 : 0)));
                        visited[nx][ny][z] = true;
                    } else if (z < k && map[nx][ny] == '1' && !visited[nx][ny][z + 1]) {
                        if (time == 0) {
                            q.add(new Node(nx, ny, z + 1, cnt + 1, 1));

                        } else if (time == 1) {
                            q.add(new Node(nx, ny, z + 1, cnt + 2, 1));
                        }
                        visited[nx][ny][z + 1] = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
