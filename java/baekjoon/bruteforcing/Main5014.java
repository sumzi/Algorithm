package baekjoon.bruteforcing;

import java.util.*;

public class Main5014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();
        boolean[] visited = new boolean[F + 1];
        visited[S] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { S, 0 });
        int ans = -1;
        while (!q.isEmpty()) {
            int[] x = q.poll();
            int cur = x[0];
            int cnt = x[1];
            if (cur == G) {
                ans = cnt;
                break;
            }
            int ncur = cur + U;
            if (F >= ncur && !visited[ncur]) {
                visited[ncur] = true;
                q.add(new int[] { ncur, cnt + 1 });
            }
            ncur = cur - D;
            if (1 <= ncur && !visited[ncur]) {
                visited[ncur] = true;
                q.add(new int[] { ncur, cnt + 1 });
            }
        }
        if (ans == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(ans);
        }
    }
}