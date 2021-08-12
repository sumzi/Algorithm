package baekjoon;

import java.util.*;

public class Main1992 {
    static String s;
    static int n;
    static int[][] arr;

    public static void divide(int x, int y, int z) {
        int tmp = arr[x][y];
        for (int i = x; i < x + z; i++) {
            for (int j = y; j < y + z; j++) {
                if (tmp != arr[i][j]) {
                    tmp = -1;
                    break;
                }
            }
        }
        if (tmp == -1) {
            z /= 2;
            System.out.print("(");
            divide(x, y, z);
            divide(x, y + z, z);
            divide(x + z, y, z);
            divide(x + z, y + z, z);
            System.out.print(")");
        } else if (tmp == 0) {
            System.out.print(0);
        } else {
            System.out.print(1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            s = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - 48;
            }
        }
        divide(0, 0, n);
    }
}