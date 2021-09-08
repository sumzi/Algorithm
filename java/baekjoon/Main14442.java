package baekjoon;

import java.util.*;
import java.io.*;

public class Main14442 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        boolean[][][] visited = new boolean[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 0, 0 }); // x,y,z,cnt
        visited[0][0][0] = true;
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        int ans = -1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int z = tmp[2];
            int cnt = tmp[3];

            if (x == n - 1 && y == m - 1) {
                ans = cnt + 1;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == '0' && !visited[nx][ny][z]) {
                        q.add(new int[] { nx, ny, z, cnt + 1 });
                        visited[nx][ny][z] = true;
                    } else if (z < k && map[nx][ny] == '1' && !visited[nx][ny][z + 1]) {
                        q.add(new int[] { nx, ny, z + 1, cnt + 1 });
                        visited[nx][ny][z + 1] = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
