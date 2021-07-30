package swea.stack1;

import java.util.Scanner;

public class Solution1219 {
    static int[][] adj;
    static int n,m;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            n=sc.nextInt();
            m=sc.nextInt();
            adj=new int[100][100];
            for (int j = 0; j < m; j++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                adj[x][y]=1;
            }
            flag=false;
            dfs(0);
            System.out.printf("#%d %d%n",i,flag?1:0);
        }
    }
    public static void dfs(int x){
        if(x==99){
            flag=true;
            return;
        } 
        for (int i = 0; i < 100; i++) {
            if (adj[x][i]==1){
                adj[x][i]=0;
                dfs(i);
            }
        }
    }
}
