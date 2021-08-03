package swea.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1227 {
    static int n, m = 100;
    static String s;
    static char[][] arr;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int[]> q = new LinkedList<>();
        arr = new char[m][m];
        for (int i = 0; i < 10; i++) {
            n = sc.nextInt();
            for (int j = 0; j < m; j++) {
                s = sc.next();
                for (int k = 0; k < m; k++) {
                    arr[j][k] = s.charAt(k);
                    if (arr[j][k] == '2') {
                        arr[j][k] = '1';
                        q.add(new int[] { j, k });
                    }
                }
            }
            boolean flag = false;
            while (!q.isEmpty()) {
                int[] x = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + x[0];
                    int ny = dy[j] + x[1];
                    if (0 <= nx && nx < m && 0 <= ny && ny < m && arr[nx][ny] != '1') {
                        if (arr[nx][ny] == '3') {
                            flag = true;
                            break;
                        } else {
                            arr[nx][ny] = '1';
                            q.add(new int[] { nx, ny });
                        }
                    }
                }
            }
            System.out.printf("#%d %d%n", n, flag ? 1 : 0);
        }
    }
}
