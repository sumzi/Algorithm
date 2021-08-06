package swea;

import java.util.Scanner;

public class Solution1952 {
    static int[] cnt=new int[13];
    static int[] month=new int[13];
    static int[] cost=new int[4];
    static int n,t;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 4; j++) {
                cost[j]=sc.nextInt();
            }
            for (int j = 1; j <= 12; j++) {
                cnt[j]=sc.nextInt();
            }
            for (int j = 1; j <= 12; j++) {
                month[j]=Math.min(cnt[j]*cost[0],cost[1])+month[j-1];
                if(j>2){
                    month[j]=Math.min(month[j], month[j-3]+cost[2]);
                }
                if(j==12){
                    month[j]=Math.min(month[j], cost[3]);
                }
            }
            System.out.println(month[12]);
        }
    }
}
