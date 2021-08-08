package swea.tree;

import java.util.*;

public class Solution1233 {
    static int n;
    static char[] data;

    public static boolean check(int x) {
        if (x > n)
            return true;
        if (x * 2 <= n || x * 2 + 1 <= n) {
            if (Character.isDigit(data[x])) {
                return false;
            } else {
                return check(x * 2) && check(x * 2 + 1);
            }
        } else {
            if (Character.isDigit(data[x])) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {

            n = sc.nextInt();
            sc.next();
            data = new char[n + 1];
            for (int j = 1; j <= n; j++) {
                String[] s = sc.nextLine().split(" ");
                data[j] = s[1].charAt(0);
            }
            System.out.println("#" + (i + 1) + " " + (check(1) ? 1 : 0));
        }
    }
}