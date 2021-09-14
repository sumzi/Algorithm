package baekjoon.data_structures;

import java.util.*;

public class Main1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = sc.next();
            if (set.contains(name)) {
                list.add(name);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (String name : list) {
            System.out.println(name);
        }
    }
}
