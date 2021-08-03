package swea.array2;
import java.io.*;
import java.util.*;

public class Solution1210 {
    static int[] dy={0,0,-1};
    static int[] dx={-1,1,0};
    static int n;
    static int[] start;
    static int[][] arr = new int[100][100];
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            n=Integer.parseInt(br.readLine());   
            for (int j = 0; j < 100; j++) {
                st=new StringTokenizer(br.readLine()," ");
                for (int k = 0; k < 100; k++) {
                    arr[j][k]=Integer.parseInt(st.nextToken());
                    if (j==99 && arr[j][k]==2){
                        start=new int[]{j,k};
                    }
                }
            }
            dfs(start[0],start[1]);
            System.out.printf("#%d %d%n",n,ans);
        }
        
    }
    public static void dfs(int y,int x){
        if (y==0) {
            ans=x;
            return;   
        }
        for (int i = 0; i < 3; i++) {
            int ny=y+dy[i];
            int nx=x+dx[i];
            if (0<=ny &&ny<100 && 0<=nx &&nx<100 && arr[ny][nx]==1){
                arr[ny][nx]=0;
                dfs(ny,nx);
                break;
            }
        }
    }
}
