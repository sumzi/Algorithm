package swea.array2;

import java.io.*;
import java.util.*;

public class Solution1209 {
    static int n, ans, tmp;
    static int[][] arr = new int[100][100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            n = Integer.parseInt(br.readLine());
            ans = 0;
            for (int j = 0; j < 100; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                tmp = 0;
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    tmp += arr[j][k];
                }
                ans = Math.max(ans, tmp);
            }
            for (int j = 0; j < 100; j++) {
                tmp = 0;
                for (int k = 0; k < 100; k++) {
                    tmp += arr[k][j];
                }
                ans = Math.max(ans, tmp);
            }
            tmp = 0;
            for (int j = 0; j < 100; j++) {
                tmp += arr[j][j];
            }
            ans = Math.max(ans, tmp);
            tmp = 0;
            for (int j = 0; j < 100; j++) {
                tmp += arr[99 - n][j];
            }
            ans = Math.max(ans, tmp);
            System.out.printf("#%d %d%n", n, ans);
        }
    }
}
