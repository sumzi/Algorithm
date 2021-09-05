package baekjoon.divide_and_conquer;

import java.util.Scanner;

public class Main1074 {
    static int n, r, c, ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        double tmp = Math.pow(2, n);
        z(0, 0, (int) tmp);
    }

    public static void z(int x, int y, int cnt) {
        if (x == r && y == c) {
            System.out.println(ans);
            return;
        }
        cnt /= 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (x + (i * cnt) <= r && r < x + (i * cnt) + cnt && y + (j * cnt) <= c && c < y + (j * cnt) + cnt) {
                    z(x + (i * cnt), y + (j * cnt), cnt);
                    return;
                } else {
                    ans += cnt * cnt;
                }
            }
        }
    }
}