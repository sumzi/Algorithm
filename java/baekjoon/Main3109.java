package baekjoon;

import java.io.*;
import java.util.*;

public class Main3109 {
    static int r, c, ans;
    static char[][] map;
    static boolean flag;
    static int[] dr = { -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < r; i++) {
            if(dfs(i, 0)) ans++;
        }
        System.out.println(ans);
    }

    public static boolean dfs(int x, int y) {
        if (y == c - 1) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int nr = x + dr[i];
            int nc = y + 1;
            if (0 <= nr && nr < r && 0 <= nc && nc < c) {
                if (map[nr][nc] == 'x')
                    continue;
                map[nr][nc] = 'x';
                if (dfs(nr, nc)) {
                    return true;
                }
            }
        }
        return false;
    }
}