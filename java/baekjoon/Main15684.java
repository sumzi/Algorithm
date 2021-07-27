package baekjoon;
import java.util.*;
/**
 * Main15684
 */
public class Main15684 {
    static int n,m,h,a,b,ans=Integer.MAX_VALUE;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        h=sc.nextInt();
        arr=new int[h+1][n+1];
        for (int i = 0; i < m; i++) {
            a=sc.nextInt();
            b=sc.nextInt();
            arr[a][b]=1;
        }
        addLine(1,0);
        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
    }
    static boolean check(){
        for (int i = 1; i < n+1; i++) {
            int cur = i;
            for (int j = 1; j < h+1; j++) {
                if (arr[j][cur]==1){
                    cur+=1;
                }else if (arr[j][cur-1]==1){
                    cur-=1;
                }
            }
            if(cur!=i){
                return false;
            }
        }
        return true;
    }
    static void addLine(int x,int y){
        if (y>3) return;
        if (check()) {
            ans=Math.min(ans, y);
            return;
        }
        for (int i = x; i < h+1; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j-1]==1 ||arr[i][j]==1 ||arr[i][j+1]==1) continue;
                arr[i][j]=1;
                addLine(i,y+1);
                arr[i][j]=0;
            }
        }
    }
}