package baekjoon;

import java.util.Scanner;

public class Main1987 {
    static boolean[] alpha;
    static int r, c, ans = 0;
    static int[][] map;
    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new int[r][c];
        alpha = new boolean[26];
        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j) - 'A';
            }
        }
        alpha[map[0][0]] = true;
        tracking(0, 0, 1);
        System.out.println(ans);
    }

    public static void tracking(int x, int y, int z) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];
            if (0 <= nr && nr < r && 0 <= nc && nc < c) {
                int tmp = map[nr][nc];
                if (!alpha[tmp]) {
                    flag = false;
                    alpha[tmp] = true;
                    tracking(nr, nc, z + 1);
                    alpha[tmp] = false;
                }
            }
        }
        if (flag) {
            ans = Math.max(ans, z);
        }
    }
}