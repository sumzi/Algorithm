package baekjoon.data_structures;

import java.util.*;

public class Main3015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<int[]> stack = new Stack<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= x) {
                ans += stack.peek()[1];
                if (stack.peek()[0] == x) {
                    y += stack.peek()[1];
                }
                stack.pop();
            }
            if (!stack.isEmpty())
                ans++;
            stack.add(new int[] { x, y });
        }
        System.out.println(ans);
    }
}
