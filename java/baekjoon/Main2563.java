package baekjoon;

import java.util.Scanner;

public class Main2563 {
    static int[][] arr = new int[101][101];
    static int n, x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            
            for (int j = x ; j < x + 10; j++) {
                for (int k = y ; k < y + 10; k++) {
                    if (arr[j][k]==0){
                        arr[j][k] = 1;
                        ans++;
                    }
                    
                }
            }
        }
        System.out.println(ans);
    }
}