package swea.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1225 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            q.clear();
            n = sc.nextInt();
            for (int j = 0; j < 8; j++) {
                q.add(sc.nextInt());
            }
            boolean flag = true;
            while (flag) {
                for (int k = 1; k < 6; k++) {
                    int x = q.poll();
                    if (x - k > 0) {
                        q.add(x - k);
                    } else {
                        q.add(0);
                        flag = false;
                        break;
                    }
                }
            }
            System.out.print("#" + n + " ");
            for (Integer a : q) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
