package baekjoon;

import java.util.*;

public class Main13913 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] log = new int[100001];
    Arrays.fill(log, -1);
    log[n] = n;
    ArrayList<Integer> ans = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    q.add(n);
    while (!q.isEmpty()) {
      int x = q.poll();
      if (x == k) {
        int t = x;
        ans.add(k);
        while (true) {
          if (log[t] != n) {
            ans.add(log[t]);
            t = log[t];
          } else {
            ans.add(n);
            break;
          }
        }
        break;
      }
      if (x - 1 >= 0 && log[x - 1] == -1) {
        q.add(x - 1);
        log[x - 1] = x;
      }
      if (x + 1 < 100001 && log[x + 1] == -1) {
        q.add(x + 1);
        log[x + 1] = x;
      }
      if (x * 2 < 100001 && log[x * 2] == -1) {
        q.add(x * 2);
        log[x * 2] = x;
      }
    }

    if (n == k) {
      System.out.println(0);
      System.out.println(n);
    } else {
      System.out.println(ans.size() - 1);
      Collections.reverse(ans);
      for (Integer i : ans) {
        System.out.print(i + " ");
      }
    }

  }
}