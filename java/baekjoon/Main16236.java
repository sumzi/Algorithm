package baekjoon;

import java.util.*;

public class Main16236 {
    static class Shark implements Comparable<Shark> {
        int x, y, time;

        Shark(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public int compareTo(Shark o) {
            if (this.time == o.time) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.time - o.time;
        }
    }

    static int[] dx = { -1, 0, 0, 1 };
    static int[] dy = { 0, -1, 1, 0 };
    static int n, sx, sy, size = 2, cnt = 2, ans = 0;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 9) {
                    sx = i;
                    sy = j;
                    arr[i][j] = 0;
                }
            }
        }
        while (true) {
            Shark baby = bfs(sx, sy);
            if (baby == null)
                break;
            sx = baby.x;
            sy = baby.y;
            ans += baby.time;
            arr[sx][sy] = 0;
            if (--cnt == 0) {
                size++;
                cnt = size;
            }
        }
        System.out.println(ans);
    }

    public static Shark bfs(int x, int y) {
        boolean[][] visited = new boolean[n][n];
        Queue<Shark> q = new LinkedList<>();
        ArrayList<Shark> list = new ArrayList<>();
        q.add(new Shark(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Shark baby = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = baby.x + dx[i];
                int ny = baby.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
                    if (arr[nx][ny] <= size) {
                        visited[nx][ny] = true;
                        q.add(new Shark(nx, ny, baby.time + 1));
                        if (0 < arr[nx][ny] && arr[nx][ny] < size) {
                            list.add(new Shark(nx, ny, baby.time + 1));
                        }
                    }
                }
            }
        }
        if (list.isEmpty())
            return null;
        Collections.sort(list);
        return list.get(0);
    }
}
