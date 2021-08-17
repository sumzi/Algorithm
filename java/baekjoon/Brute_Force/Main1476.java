package baekjoon.Brute_Force;

import java.util.*;

public class Main1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int answer = 1;
        while (true) {
            if ((answer - e) % 15 == 0 && (answer - s) % 28 == 0 && (answer - m) % 19 == 0) {
                System.out.println(answer);
                break;
            }
            answer++;
        }
    }
}
