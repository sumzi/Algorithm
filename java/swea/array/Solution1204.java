package swea.array;

import java.util.Scanner;

public class Solution1204 {
    static int t,n,m;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t=sc.nextInt();
        while(t-->0){
            n=sc.nextInt();
            int[] arr=new int[1000];
            int x=0;
            int y=0;
            for (int i = 0; i < 1000; i++) {
                m=sc.nextInt();
                arr[m]++;
                if (arr[m]>x){
                    x=arr[m];
                    y=m;
                }else if(arr[m]==x && y<m){
                    y=m;
                }
            }
            System.out.printf("#%d %d%n",n,y);
        }
        sc.close();
    }
}
