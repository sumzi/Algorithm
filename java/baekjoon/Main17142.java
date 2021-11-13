package baekjoon;

import java.util.*;
import java.io.*;

public class Main17142 {
  static class Node {
    int x, y, time;

    Node(int x, int y, int time) {
      this.x = x;
      this.y = y;
      this.time = time;
    }
  }

  static int n, m, ans = Integer.MAX_VALUE, num;
  static int[][] map;
  static List<Node> arr = new ArrayList<>();
  static Node[] selected;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][n];
    selected = new Node[m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) {
          arr.add(new Node(i, j, 0));
        } else if (map[i][j] == 0) {
          num++;
        }
      }
    }
    if (num == 0) {
      System.out.println(0);
    } else {
      select(0, 0);
      if (ans == Integer.MAX_VALUE) {
        System.out.println(-1);
      } else {
        System.out.println(ans);
      }
    }
  }

  public static void select(int idx, int cnt) {
    if (cnt == m) {
      bfs(num);
      return;
    }
    for (int i = idx; i < arr.size(); i++) {
      selected[cnt] = arr.get(i);
      select(i + 1, cnt + 1);
    }
  }

  public static void bfs(int cnt) {
    boolean[][] visited = new boolean[n][n];
    Queue<Node> q = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      Node node = selected[i];
      visited[node.x][node.y] = true;
      q.add(node);
    }
    while (!q.isEmpty()) {
      Node cur = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
          if (map[nx][ny] == 1 || visited[nx][ny])
            continue;

          if (map[nx][ny] == 0)
            cnt--;
          if (cnt == 0) {
            ans = Math.min(ans, cur.time + 1);
            return;
          }
          visited[nx][ny] = true;
          q.add(new Node(nx, ny, cur.time + 1));
        }
      }
    }
  }
}
