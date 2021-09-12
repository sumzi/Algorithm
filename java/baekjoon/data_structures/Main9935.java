package baekjoon.data_structures;

import java.util.*;

public class Main9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        int n = s1.length();
        String s2 = sc.nextLine();
        int m = s2.length();
        boolean[] check = new boolean[n];

        if (m == 1) {
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) == s2.charAt(0))
                    check[i] = true;
            }
        } else {
            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) == s2.charAt(0)) {
                    stack.add(new int[] { i, 0 });
                } else {
                    if (!stack.isEmpty()) {
                        int[] x = stack.peek();
                        if (x[1] + 1 < m && s1.charAt(i) == s2.charAt(x[1] + 1)) {
                            stack.add(new int[] { i, x[1] + 1 });
                            if (x[1] + 1 == m - 1) {
                                for (int j = 0; j < m; j++) {
                                    int[] y = stack.pop();
                                    check[y[0]] = true;
                                }
                            }
                        } else {
                            while (!stack.isEmpty()) {
                                stack.pop();
                            }
                        }
                    }
                }
            }
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                sb.append(s1.charAt(i));
                flag = true;
            }
        }
        if (!flag)
            System.out.println("FRULA");
        else
            System.out.println(sb);
    }
}