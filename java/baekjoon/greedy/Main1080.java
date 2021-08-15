package baekjoon.greedy;

import java.util.*;
import java.io.*;

public class Main1080 {
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        char[][] arr2 = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr2[i][j] = s.charAt(j);
            }
        }
        int answer = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (arr[i][j] != arr2[i][j]) {
                    reverse(i, j);
                    answer++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != arr2[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }

    private static void reverse(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (arr[i][j] == '0') {
                    arr[i][j] = '1';
                } else {
                    arr[i][j] = '0';
                }
            }
        }
    }
}
