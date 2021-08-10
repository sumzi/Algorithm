package baekjoon;

import java.util.*;

public class Main1759 {
    static int l, c;
    static char[] arr;

    public static boolean check(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }

    public static void code(int idx, int mo, int ja, String s) {
        if (s.length() == l) {
            if (mo >= 1 && ja >= 2) {
                System.out.println(s);
            }
            return;
        }
        if (idx == c)
            return;
        if (check(arr[idx])) {
            code(idx + 1, mo + 1, ja, s + arr[idx]);
        } else {
            code(idx + 1, mo, ja + 1, s + arr[idx]);
        }
        code(idx + 1, mo, ja, s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        arr = new char[c];
        for (int i = 0; i < c; i++) {
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);
        code(0, 0, 0, "");
    }
}
