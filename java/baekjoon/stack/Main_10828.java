package java.baekjoon.stack;
import java.util.*;
import java.io.*;

public class Main_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Stack<Integer> stack = new Stack<Integer>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String m = st.nextToken();
            if (m.contains("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (m.contains("pop")) {
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            } else if (m.contains("size")) {
                System.out.println(stack.size());
            } else if (m.contains("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else if (m.contains("top")) {
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
        }
    }
}
