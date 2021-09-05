package baekjoon.divide_and_conquer;

import java.util.Arrays;
import java.util.Scanner;

public class Main2448 {
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n * 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], ' ');
        }
        star(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void star(int x, int y, int cnt) {
        if (cnt == 3) {
            arr[x][y + 2] = '*';
            arr[x + 1][y + 1] = '*';
            arr[x + 1][y + 3] = '*';
            for (int i = 0; i < 5; i++) {
                arr[x + 2][y + i] = '*';
            }
            return;
        }
        cnt /= 2;
        star(x, y + cnt, cnt);
        star(x + cnt, y, cnt);
        star(x + cnt, y + (cnt * 2), cnt);
    }
}
