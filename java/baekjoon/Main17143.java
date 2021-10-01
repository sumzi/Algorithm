package baekjoon;

import java.util.*;
import java.io.*;

public class Main17143 {
    static int r, c;
    static int[] dx = { 0, -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 0, 1, -1 };

    static class Shark {
        int x, y, s, d, z;

        Shark(int x, int y, int s, int d, int z) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        void move() {
            for (int i = 0; i < s; i++) {
                x += dx[d];
                y += dy[d];
                if (x == 0) {
                    x = 2;
                    d = 2;
                } else if (x > r) {
                    x = r - 1;
                    d = 1;
                } else if (y == 0) {
                    y = 2;
                    d = 3;
                } else if (y > c) {
                    y = c - 1;
                    d = 4;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Shark[][] map = new Shark[r + 1][c + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if (d == 1 || d == 2) {
                s %= (2 * r - 2);
            } else if (d == 3 || d == 4) {
                s %= (2 * c - 2);
            }
            if (map[x][y] == null || map[x][y].z < z) {
                map[x][y] = new Shark(x, y, s, d, z);
            }
        }
        Queue<Shark> q = new LinkedList<>();
        int ans = 0;
        for (int i = 1; i <= c; i++) {
            boolean flag = true;
            for (int j = 1; j <= r; j++) {
                for (int k = 1; k <= c; k++) {
                    if (map[j][k] != null) {
                        if (i == k && flag) {
                            flag = false;
                            ans += map[j][k].z;
                        } else {
                            q.add(map[j][k]);
                        }
                        map[j][k] = null;
                    }

                }
            }
            while (!q.isEmpty()) {
                for (int j = 0; j < q.size(); j++) {
                    Shark shark = q.poll();
                    shark.move();

                    if (map[shark.x][shark.y] == null || map[shark.x][shark.y].z < shark.z) {
                        map[shark.x][shark.y] = shark;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}