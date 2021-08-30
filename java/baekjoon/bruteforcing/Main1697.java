package baekjoon.bruteforcing;

import java.util.*;

public class Main1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] arr = new boolean[100001];
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { n, 0 });
        while (!q.isEmpty()) {
            int tmp[] = q.poll();
            int x = tmp[0];
            int cnt = tmp[1];
            if (x == k) {
                System.out.println(cnt);
                break;
            }
            arr[x] = true;
            if (x - 1 >= 0 && !arr[x - 1]) {
                q.add(new int[] { x - 1, cnt + 1 });
            }
            if (x + 1 <= 100000 && !arr[x + 1]) {
                q.add(new int[] { x + 1, cnt + 1 });
            }
            if (x * 2 <= 100000 && !arr[x * 2]) {
                q.add(new int[] { x * 2, cnt + 1 });
            }
        }
    }
}