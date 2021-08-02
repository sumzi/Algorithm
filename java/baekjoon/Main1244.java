package baekjoon;

import java.util.Scanner;

public class Main1244 {
    static int[] swit;
    static int n, m, a, b;
    public static int change(int x) {
        if (x == 1)
            return 0;
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        swit = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            swit[i] = sc.nextInt();
        }
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a == 1) {
                for (int j = b; j <= n; j+=b) {
                    swit[j]=change(swit[j]);
                }
            } else {
                int l=b-1;
                int r =b+1;
                swit[b]=change(swit[b]);
                while(0<l && r<=n){
                    if (swit[l]!=swit[r]){
                        break;
                    }
                    swit[l]=change(swit[l]);
                    swit[r]=change(swit[r]);
                    l--;
                    r++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(swit[i]+" ");
            if (i%20==0) System.out.println();
        }
    }
}