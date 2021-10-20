package swea;

import java.util.*;

public class Solution4727 {
    static int n, o, m, w;
    static boolean[] num, op;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            o = sc.nextInt();
            m = sc.nextInt();
            num = new boolean[10];
            op = new boolean[5];
            for (int j = 0; j < n; j++) {
                num[sc.nextInt()] = true;
            }
            for (int j = 0; j < o; j++) {
                op[sc.nextInt()] = true;
            }
            w = sc.nextInt();
            dp = new int[w + 1];
            Arrays.fill(dp, 1000);
            // 터치하는횟수 고려,,,
        }
    }
}
