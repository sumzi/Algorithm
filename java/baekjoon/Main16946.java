package baekjoon;

import java.util.*;
import java.io.*;

public class Main16946 {
    static int[][] map;
    static int[][] dp;
    static int[][] num;
    static int n, m;

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        num = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && dp[i][j] == 0) {
                    q.add(new int[] { i, j });
                    dp[i][j] = 1;
                    int cnt = 0;
                    while (!q.isEmpty()) {
                        int[] tmp = q.poll();
                        q2.add(tmp);
                        cnt++;
                        for (int k = 0; k < 4; k++) {
                            int nx = dx[k] + tmp[0];
                            int ny = dy[k] + tmp[1];
                            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                                if (dp[nx][ny] == 0 && map[nx][ny] == 0) {
                                    dp[nx][ny] = 1;
                                    q.add(new int[] { nx, ny });
                                }
                            }
                        }
                    }
                    while (!q2.isEmpty()) {
                        int[] tmp = q2.poll();
                        dp[tmp[0]][tmp[1]] = cnt;
                        num[tmp[0]][tmp[1]] = count;
                    }
                    count++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    int cnt = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + i;
                        int ny = dy[k] + j;
                        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                            int t = num[nx][ny];
                            if (!set.contains(t) && map[nx][ny] == 0) {
                                set.add(t);
                                cnt += dp[nx][ny];
                            }
                        }
                    }
                    sb.append(cnt % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}