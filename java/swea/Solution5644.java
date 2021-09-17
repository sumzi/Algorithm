package swea;

// 무선충전(모의 sw 역량테스트)
import java.util.*;
import java.io.*;

public class Solution5644 {
    static boolean[][] visited;
    static ArrayList<Integer>[][] e;
    static int[] BC;
    static int[] A, B;
    static int[] dx = { 0, -1, 0, 1, 0 };
    static int[] dy = { 0, 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st, sta, stb;
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            e = new ArrayList[11][11];
            for (int j = 1; j < 11; j++) {
                for (int k = 1; k < 11; k++) {
                    e[j][k] = new ArrayList<>();
                }
            }
            A = new int[m];
            B = new int[m];
            BC = new int[a + 1];
            sta = new StringTokenizer(br.readLine(), " ");
            stb = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                A[j] = Integer.parseInt(sta.nextToken());
                B[j] = Integer.parseInt(stb.nextToken());
            }

            for (int j = 1; j < a + 1; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                BC[j] = p;
                bfs(x, y, c, j);
            }

            int ax = 1, ay = 1, bx = 10, by = 10;
            int answer = check(ax, ay, bx, by);
            for (int j = 0; j < m; j++) {
                ax += dx[A[j]];
                ay += dy[A[j]];
                bx += dx[B[j]];
                by += dy[B[j]];
                int tmp = check(ax, ay, bx, by);
                answer += tmp;
            }
            System.out.println("#" + i + " " + answer);
        }

    }

    public static int check(int ax, int ay, int bx, int by) {
        int num1 = e[ax][ay].size();
        int num2 = e[bx][by].size();
        int res = 0;
        if (num1 == 0 && num2 == 0)
            return 0;
        else if (num1 == 0) {
            for (int i = 0; i < num2; i++) {
                res = Math.max(res, BC[e[bx][by].get(i)]);
            }
            return res;
        } else if (num2 == 0) {
            for (int i = 0; i < num1; i++) {
                res = Math.max(res, BC[e[ax][ay].get(i)]);
            }
            return res;
        }
        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num2; j++) {
                if (e[ax][ay].get(i) == e[bx][by].get(j)) {
                    res = Math.max(res, BC[e[ax][ay].get(i)]);
                } else {
                    res = Math.max(res, BC[e[ax][ay].get(i)] + BC[e[bx][by].get(j)]);
                }
            }
        }
        return res;
    }

    public static void bfs(int x, int y, int c, int p) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });
        visited = new boolean[11][11];
        visited[x][y] = true;
        for (int i = 0; i < c + 1; i++) {
            int num = q.size();
            for (int j = 0; j < num; j++) {
                int[] tmp = q.poll();
                int xx = tmp[0];
                int yy = tmp[1];
                e[xx][yy].add(p);
                for (int k = 1; k <= 4; k++) {
                    int nx = xx + dx[k];
                    int ny = yy + dy[k];
                    if (0 < nx && nx < 11 && 0 < ny && ny < 11 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
    }
}