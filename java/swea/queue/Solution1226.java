package swea.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1226 {
    static int n;
    static String s;
    static char[][] arr = new char[16][16];
    static int[] start;
    static int[] end;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            n = sc.nextInt();
            for (int j = 0; j < 16; j++) {
                s = sc.next();
                for (int k = 0; k < 16; k++) {
                    arr[j][k] = s.charAt(k);
                    if (arr[j][k] == '2') {
                        arr[j][k] = '1';
                        q.add(new int[] { j, k });
                    } else if (arr[j][k] == '3') {
                        end = new int[] { j, k };
                    }
                }
            }

            boolean flag = false;
            while (!q.isEmpty()) {
                int[] x = q.poll();
                if (x[0] == end[0] && x[1] == end[1]) {
                    flag = true;
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + x[0];
                    int ny = dy[j] + x[1];
                    if (0 <= nx && nx < 16 && 0 <= ny && ny < 16 && arr[nx][ny] != '1') {
                        arr[nx][ny] = '1';
                        q.add(new int[] { nx, ny });
                    }
                }
            }
            System.out.printf("#%d %d%n", n, flag ? 1 : 0);
        }
    }
}
