package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main2580 {
    static int n;
    static int[][] arr = new int[9][9];
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    list.add(new int[] { i, j });
                }
            }
        }
        n = list.size();
        dfs(0);
    }

    public static boolean dfs(int cnt) {
        if (cnt == n) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        int x = list.get(cnt)[0];
        int y = list.get(cnt)[1];
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 9; i++) {
            visited[arr[x][i]] = true;
            visited[arr[i][y]] = true;
        }
        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;
        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                visited[arr[i][j]] = true;
            }
        }
        for (int i = 1; i < 10; i++) {
            if (!visited[i]) {
                arr[x][y] = i;
                if (dfs(cnt + 1)) {
                    return true;
                }
            }
        }
        arr[x][y] = 0;
        return false;
    }
}