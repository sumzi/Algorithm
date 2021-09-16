package baekjoon;

import java.util.Scanner;

public class Main9205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt() + 2;
            int[][] loc = new int[n][2];
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                loc[j][0] = sc.nextInt();
                loc[j][1] = sc.nextInt();
            }
            // 맥주 마시면서 갈 수 있는 거리인지 확인
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int tmp = Math.abs(loc[j][0] - loc[k][0]) + Math.abs(loc[j][1] - loc[k][1]);
                    if (tmp <= 1000) {
                        arr[j][k] = 1;
                        arr[k][j] = 1;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int a = 0; a < arr.length; a++) {
                    for (int b = 0; b < arr.length; b++) {
                        if (a == b)
                            continue;
                        if (arr[a][j] == 1 && arr[j][b] == 1) {
                            arr[a][b] = 1;
                        }
                    }
                }
            }
            System.out.println(arr[0][n - 1] == 1 ? "happy" : "sad");
        }
    }
}
