package baekjoon.divide_and_conquer;

import java.util.*;
import java.io.*;

public class Main1780 {
    static int[][] arr;
    static int[] ans = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, n);
        for (int i = 0; i < 3; i++) {
            System.out.println(ans[i]);
        }
    }

    public static void divide(int x, int y, int num) {
        int tmp = arr[x][y];
        for (int i = x; i < x + num; i++) {
            for (int j = y; j < y + num; j++) {
                if (arr[x][y] != arr[i][j]) {
                    num /= 3;
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            divide(x + num * k, y + num * l, num);
                        }
                    }
                    return;
                }
            }
        }
        ans[tmp + 1]++;
    }
}