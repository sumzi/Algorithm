package swea;

import java.util.Scanner;

public class Solution1954 {
    static int[] dx={1,0,-1,0};
    static int[] dy={0,-1,0,1};
    static int t, n, num, x, y,z;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            n=sc.nextInt();
            num=1;
            arr=new int[n][n];
            for (int j = 0; j < n; j++) {
                arr[0][j]=num++;
            }
            x=0;
            y=n-1;
            z=0;
            for (int a = n-1; a>0 ; a--) {
                for (int b = 0; b <  2; b++) {
                    for (int c = 0; c< a; c++) {
                        x+=dx[z%4];
                        y+=dy[z%4];
                        arr[x][y]=num++;
                    }
                    z++;
                }
            }
            System.out.println("#"+n);
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    System.out.print(arr[a][b]+" ");
                }
                System.out.println();
            }
        }
    }   
}
