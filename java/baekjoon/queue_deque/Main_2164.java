import java.util.*;
public class Main_2164 {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n+1; i++) {
            q.add(i);
        }
        for (int i = 0; i < n-1; i++) {
            q.pollFirst();
            m=q.pollFirst();
            q.add(m);
        }
        System.out.println(q.poll());
    }   
}
