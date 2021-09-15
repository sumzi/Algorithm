package baekjoon.data_structures;

import java.util.*;
import java.io.*;

public class Main2346 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(new int[] { Integer.parseInt(st.nextToken()), i });
        }
        while (!deque.isEmpty()) {
            sb.append(deque.getFirst()[1] + " ");
            int[] next = deque.poll();
            if (deque.isEmpty())
                break;

            if (next[0] > 0) {
                next[0] -= 1;
                for (int i = 0; i < next[0]; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(next[0]); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
}
