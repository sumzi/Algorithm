package baekjoon.divide_and_conquer;

import java.util.Arrays;
import java.util.Scanner;

public class Main2447 {
    static int n;
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n][n];
        star(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void star(int x, int y, int cnt) {
        if (cnt == 1) {
            arr[x][y] = '*';
            return;
        }
        cnt /= 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    for (int a = (i * cnt) + x; a < (i * cnt) + x + cnt; a++) {
                        for (int b = (j * cnt) + y; b < (j * cnt) + y + cnt; b++) {
                            arr[a][b] = ' ';
                        }
                    }
                } else {
                    star(x + (i * cnt), y + (j * cnt), cnt);
                }
            }
        }
    }
}
