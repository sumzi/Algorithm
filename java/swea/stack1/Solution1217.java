package swea.stack1;

import java.util.Scanner;

public class Solution1217 {
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            int z=sc.nextInt();
            n=sc.nextInt();
            m=sc.nextInt();
            System.out.printf("#%d %d%n",i,recursion(n,m));
        }
    } 
    public static int recursion(int x,int y){
        if (y==1) return x;
        return x*recursion(x,y-1);
    }
}
