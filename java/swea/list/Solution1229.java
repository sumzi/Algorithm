package swea.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1229 {
    static int n, m, x, y;
    static String c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> code = new LinkedList<>();

        for (int t = 0; t < 10; t++) {
            code.clear();
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                code.add(sc.nextInt());
            }
            m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                c = sc.next();
                x = sc.nextInt();
                y = sc.nextInt();
                if (c.equals("I")) {
                    for (int j = x; j < x + y; j++) {
                        code.add(j, sc.nextInt());
                    }
                } else if (c.equals("D")) {
                    for (int j = 0; j < y; j++) {
                        code.remove(x);
                    }
                }

            }
            System.out.print("#" + (t + 1));
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + code.get(i));
            }
            System.out.println();
        }

    }
}
