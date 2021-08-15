package baekjoon.greedy;
/**
 *  m+k-1<=n<mk 만 가능
 *  숫자를 오름차순으로 m개만큼 k개보다 같거나 작게 수를 나눠 준다.
 *  나눈 수를 역순으로 정렬
 */
import java.util.*;

public class Main1201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        if (m + k - 1 > n || n > m * k) {
            System.out.println(-1);
        }else{
            List<Integer> list = new LinkedList<>();
            list.add(k);
            n -= k;
            m-=1;
            if(m!=0){
                int tmp = n % m;
                for (int i = 0; i < m ; i++) {
                    if (tmp > 0) {
                        list.add(n / m + 1);
                        tmp--;
                    } else {
                        list.add(n / m );
                    }
                }
            }
            int cnt = 0;
            for (Integer i : list) {
                for (int j = cnt + i; j > cnt; j--) {
                    System.out.print(j + " ");
                }
                cnt += i;
            }
        }
    }
}
