package baekjoon;
import java.util.*;
public class Main1956 {
    static final int INF=10000000;
    static int v,e,a,b,c,ans;
    static int[][] dist;
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v=sc.nextInt();
        e=sc.nextInt();
        dist=new int[v+1][v+1];
        ans=INF;
        for (int i = 0; i < v+1; i++) {
            for (int j = 0; j < v+1; j++) {
                dist[i][j]=INF;
            }
        }
        for (int i = 0; i < e; i++) {
            a=sc.nextInt();
            b=sc.nextInt();
            c=sc.nextInt();
            dist[a][b]=c;
        }
        for (int i = 1; i < v+1; i++) {
            for (int j = 1; j < v+1; j++) {
                for (int k = 1; k < v+1; k++) {
                    dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        for (int i = 1; i < v+1; i++) {
            ans=Math.min(ans,dist[i][i]);
        }
        System.out.println(ans==INF?-1:ans);
    }
}