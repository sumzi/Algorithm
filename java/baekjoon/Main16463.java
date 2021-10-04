package baekjoon;

import java.util.*;

public class Main16463 {
    static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int ans = 0;
        int d = 13;
        for (int i = 2019; i <= y; i++) {
            for (int j = 1; j <= 12; j++) {
                if (d % 7 == 4)
                    ans++;
                d += days[j];
                if (j == 2 && ((i % 100 != 0 && i % 4 == 0) || (i % 400 == 0)))
                    d++;
            }
        }
        System.out.println(ans);
    }
}
