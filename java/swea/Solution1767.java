package swea;

import java.util.*;
import java.io.*;

public class Solution1767 {
    static int n, m, ans1, ans2;
    static int[][] arr;
    static int[][] visited;
    static ArrayList<int[]> core = new ArrayList<>();
    static int[] dx = { 0, 0, -1, 1 }; // 좌, 우, 상, 하
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine().trim());
            arr = new int[n][n];
            visited = new int[n][n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[j], -1);
            }
            core = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    if (arr[j][k] == 1 && 0 < j && j < n - 1 && 0 < k && k < n - 1) {
                        core.add(new int[] { j, k });
                    }
                }
            }
            m = core.size();
            ans1 = 0;
            ans2 = 1000;
            dfs(0, 0, 0);
            System.out.println("#" + i + " " + ans2);
        }
    }

    public static void dfs(int idx, int cnt, int num) {
        if (idx == m) {
            if (ans1 < cnt) {
                ans1 = cnt;
                ans2 = num;
            } else if (ans1 == cnt) {
                if (ans2 > num)
                    ans2 = num;
            }
            return;
        }
        int x = core.get(idx)[0];
        int y = core.get(idx)[1];
        for (int i = 0; i < 4; i++) {
            int tmp = check(x, y, i, idx);
            if (tmp > 0) {
                dfs(idx + 1, cnt + 1, num + tmp);
            } else {
                dfs(idx + 1, cnt, num);
            }
            delete(x, y, i, idx);
        }
    }

    public static int check(int x, int y, int z, int idx) {
        int num = 0;
        while (true) {
            x += dx[z];
            y += dy[z];
            if (x < 0 || y < 0 || x >= n || y >= n) {
                return num;
            }
            if (arr[x][y] == 0 && visited[x][y] == -1) {
                visited[x][y] = idx;
                num++;
            } else {
                return -1;
            }
        }
    }

    public static void delete(int x, int y, int z, int idx) {
        while (true) {
            x += dx[z];
            y += dy[z];
            if (x < 0 || y < 0 || x >= n || y >= n) {
                return;
            }
            if (visited[x][y] == idx) {
                visited[x][y] = -1;
            } else {
                return;
            }
        }
    }
}