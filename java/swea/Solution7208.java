package swea;

import java.util.Scanner;

public class Solution7208 {
    static int t, n, ans;
    static int[][] arr;
    static int[] color = new int[4];
    static int[] numbers;
    static boolean[] selected;

    public static boolean check(){
        for (int i = 0; i < n-1; i++) {
            for (int j = 1+i; j < n; j++) {
                if(arr[i][j]==1){
                    if(numbers[i]==numbers[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void permutation(int cnt){
        if(cnt==n){
            if(check()){
                int num=0;
                for (int i = 0; i < n; i++) {
                    if(color[i]!=numbers[i]) num++;
                }
                ans=Math.min(ans,num);
            }
            return;
        }
        for(int i=0;i<4;i++){
            numbers[cnt]=i;
            permutation(cnt+1);
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            n=sc.nextInt();
            arr=new int[n][n];
            numbers=new int[n];
            selected=new boolean[n];
            color=new int[n];
            ans=8;
            for (int j = 0; j < n; j++) {
                color[j]=sc.nextInt()-1;
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k]=sc.nextInt();
                }
            }
            permutation(0);
            System.out.printf("#%d %d%n",i+1,ans);
        }
    }
}
