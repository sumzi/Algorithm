package baekjoon;

import java.util.*;
import java.io.*;

public class Main2578 {
    static int[][] arr = new int[5][5];
    static int[] x = new int[5];
    static int[] y = new int[5];
    static int[] z = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        int cnt = 1;
        boolean flag = true;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                game(tmp);
                if (flag && check() >= 3) {
                    flag = false;
                    ans = cnt;
                    break;
                }
                cnt++;
            }
        }
        System.out.println(ans);
    }

    public static int check() {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (x[i] == 5)
                cnt++;
            if (y[i] == 5)
                cnt++;
            if (i < 2 && z[i] == 5)
                cnt++;
        }
        return cnt;
    }

    public static void game(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == num) {
                    x[i]++;
                    y[j]++;
                    if (i + j == 4)
                        z[0]++;
                    if (i == j)
                        z[1]++;
                }
            }
        }
    }
}