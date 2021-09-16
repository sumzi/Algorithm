package baekjoon.data_structures;

import java.util.Scanner;
import java.util.Stack;

public class Main1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (idx <= x) {
                while (idx <= x) {
                    stack.add(idx++);
                    sb.append("+\n");
                }
            }
            if (stack.peek() == x) {
                stack.pop();
                sb.append("-\n");
            } else {
                flag = false;
            }
        }
        System.out.println(flag ? sb : "NO");
    }
}