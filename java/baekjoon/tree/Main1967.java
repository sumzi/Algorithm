package baekjoon.tree;

import java.util.*;

public class Main1967 {
    static class Node {
        int no, weight;

        Node(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }

    static int n, ans;
    static ArrayList<Node>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list[a].add(new Node(b, c));
        }
        solution(1, 0);
        System.out.println(ans);
    }

    public static int solution(int cur, int num) {
        ArrayList<Integer> max = new ArrayList<>();
        for (Node x : list[cur]) {
            max.add(solution(x.no, x.weight));
        }
        if (max.size() == 0) {
            return num;
        } else {
            Collections.sort(max, Collections.reverseOrder());
            if (max.size() > 1) {
                ans = Math.max(ans, max.get(0) + max.get(1));
            } else {
                ans = Math.max(ans, max.get(0));
            }
            return num + max.get(0);
        }
    }
}