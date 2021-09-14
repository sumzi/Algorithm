package baekjoon.data_structures;

import java.util.*;

public class Main11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                System.out.println(q.isEmpty() ? 0 : q.poll());
            } else {
                q.add(x);
            }
        }
    }
}