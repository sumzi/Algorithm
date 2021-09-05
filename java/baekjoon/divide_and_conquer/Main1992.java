package baekjoon.divide_and_conquer;

import java.util.*;
import java.io.*;

public class Main1992 {
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        quad(0, 0, n);
        System.out.println(sb);
    }

    static public void quad(int x, int y, int cnt) {
        if (cnt == 1) {
            sb.append(arr[x][y]);
            return;
        }
        char tmp = arr[x][y];
        for (int i = x; i < x + cnt; i++) {
            for (int j = y; j < y + cnt; j++) {
                if (arr[i][j] != tmp) {
                    cnt /= 2;
                    sb.append("(");
                    quad(x, y, cnt);
                    quad(x, y + cnt, cnt);
                    quad(x + cnt, y, cnt);
                    quad(x + cnt, y + cnt, cnt);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(tmp);
    }
}