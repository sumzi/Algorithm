package baekjoon;

import java.util.*;

public class Main14890 {
    static int n, l;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 가로 비교
            int cnt = 1; // 높이가 같은 타일수
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else if (cnt >= 0 && arr[i][j - 1] == arr[i][j] + 1) {
                    cnt = -l + 1;
                } else if (cnt >= l && arr[i][j - 1] + 1 == arr[i][j]) {
                    cnt = 1;
                } else {
                    cnt = -1;
                    break;
                }
            }
            if (cnt >= 0)
                ans++;

            // 세로 비교
            cnt = 1; // 높이가 같은 타일수
            for (int j = 1; j < n; j++) {
                if (arr[j - 1][i] == arr[j][i]) {
                    cnt++;
                } else if (cnt >= 0 && arr[j - 1][i] == arr[j][i] + 1) {
                    cnt = -l + 1;
                } else if (cnt >= l && arr[j - 1][i] + 1 == arr[j][i]) {
                    cnt = 1;
                } else {
                    cnt = -1;
                    break;
                }
            }
            if (cnt >= 0)
                ans++;
        }
        System.out.println(ans);
    }
}
