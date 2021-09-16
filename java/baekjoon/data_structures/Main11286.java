package baekjoon.data_structures;

import java.util.*;

public class Main11286 {

    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x) {
            this.x = Math.abs(x);
            this.y = x;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                System.out.println(q.isEmpty() ? 0 : q.poll().y);
            } else {
                q.add(new Pair(x));
            }
        }
    }
}