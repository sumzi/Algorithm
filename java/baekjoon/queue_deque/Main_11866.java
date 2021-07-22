import java.util.*;

public class Main_11866 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();   
        for (int i = 1; i < n+1; i++) {
            q.add(i);
        }
        sb.append("<");
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < k-1; j++) {
                int m=q.poll();
                q.offer(m);
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}
