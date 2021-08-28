package baekjoon;
import java.util.*;
import java.io.*;

public class Main11779 {
    static class Node implements Comparable<Node>{
        int no;
        int cost;
        public Node(int no, int cost){
            this.no = no;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int[] visited = new int[n+1];
        int[] dp= new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        ArrayList<Node>[] adj = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            adj[i]= new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b,c));
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] check= new boolean[n+1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        dp[start]= 0;
        while(!q.isEmpty()){
            Node x = q.poll();
            if(check[x.no]) continue;
            check[x.no]=true;
            for (Node nx : adj[x.no]) {
                if(dp[nx.no]>dp[x.no]+nx.cost){
                    dp[nx.no]=dp[x.no]+nx.cost;
                    visited[nx.no]=x.no;
                    q.offer(new Node(nx.no,dp[nx.no]));
                }
            }
        }
        
        Stack<Integer> s = new Stack<>();
        int idx = end;
        while(idx!=0){
            s.add(idx);
            idx=visited[idx];
        }
        System.out.println(dp[end]);
        System.out.println(s.size());
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println(Arrays.toString(visited));
    }
}