package baekjoon;

import java.util.*;
import java.io.*;

public class Main16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int N = n, M = m;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int tmp = Math.min(n, m);
        for (int i = 0; i < tmp / 2; i++) {

            for (int j = 0; j < r; j++) {
                int num = arr[i][i];
                for (int k = i; k < m - 1; k++) {
                    arr[i][k] = arr[i][k + 1];
                }
                for (int k = i; k < n - 1; k++) {
                    arr[k][m - 1] = arr[k + 1][m - 1];
                }
                for (int k = m - 1; k > i; k--) {
                    arr[n - 1][k] = arr[n - 1][k - 1];
                }
                for (int k = n - 1; k > i; k--) {
                    arr[k][i] = arr[k - 1][i];
                }
                arr[i + 1][i] = num;
            }
            n--;
            m--;
        }

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                System.out.print(arr[j][k] + " ");
            }
            System.out.println();
        }
    }
}
