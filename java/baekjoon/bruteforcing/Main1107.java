package baekjoon.bruteforcing;

import java.util.*;
import java.io.*;

public class Main1107 {
    static int n, ans;
    static boolean[] number;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = new boolean[10];
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                number[Integer.parseInt(st.nextToken())] = true;
            }
        }
        ans = Math.abs(n - 100);
        for (int i = 0; i < 1000001; i++) {
            int tmp = check(i);
            if (0 < tmp) {
                ans = Math.min(ans, Math.abs(n - i) + tmp);
            }
        }
        System.out.println(ans);
    }

    private static int check(int x) {
        if (x == 0) {
            if (number[0])
                return 0;
            return 1;
        }
        int len = 0;
        while (x > 0) {
            if (number[x % 10])
                return 0;
            x /= 10;
            len++;
        }
        return len;
    }
}