package baekjoon;

import java.io.*;
import java.util.*;

public class Main2493 {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<int[]> s = new Stack<>();
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            m = Integer.parseInt(st.nextToken());
            if (!s.isEmpty() && s.peek()[0] < m) {
                while (!s.isEmpty() && s.peek()[0] < m) {
                    s.pop();
                }
            }
            System.out.print((s.isEmpty() ? 0 : s.peek()[1]) + " ");
            s.push(new int[] { m, i });
        }
    }
}