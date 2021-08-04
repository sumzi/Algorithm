package swea.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1228 {
    static int n, m, x, y;

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
                sc.next();
                x = sc.nextInt();
                y = sc.nextInt();
                for (int j = x; j < x + y; j++) {
                    code.add(j, sc.nextInt());
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
