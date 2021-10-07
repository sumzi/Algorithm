package baekjoon.graph;

import java.util.*;

public class Main11780 {
    static long[][] arr;
    static int[][] visited;
    static Stack<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int INF = Integer.MAX_VALUE;
        arr = new long[n + 1][n + 1];
        visited = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(arr[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr[a][b] = Math.min(arr[a][b], c);
        }
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j)
                        continue;
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        visited[i][j] = k;
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print((arr[i][j] == INF ? 0 : arr[i][j]) + " ");
            }
            System.out.println();
        }
        list = new Stack<>();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (arr[i][j] == INF) {
                    System.out.println(0);
                } else {
                    list.clear();
                    find(i, j);
                    System.out.println(list.size());
                    for (Integer x : list) {
                        System.out.print(x + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void find(int x, int y) {
        if (visited[x][y] == 0) {
            list.add(x);
            list.add(y);
            return;
        }
        find(x, visited[x][y]);
        list.pop();
        find(visited[x][y], y);
    }
}