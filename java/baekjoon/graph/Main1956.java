package baekjoon.graph;

import java.util.*;

public class Main1956 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int INF = 100000000;
        long[][] arr = new long[v + 1][v + 1];
        for (int i = 0; i < v + 1; i++) {
            Arrays.fill(arr[i], INF);
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr[a][b] = c;
        }
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        long ans = INF;
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (arr[i][j] + arr[j][i] < INF) {
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }
        System.out.println(ans == INF ? -1 : ans);
    }
}
