package swea.tree;

import java.util.*;

/**
 *  1233. [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사 D4
 * 
 *  리프노드는 무조건 숫자데이터, 나머지는 무조건 연산자 아니라면 유효성 0 
 *  Character.isDigit(char c): boolean
 *  형태로 문자가 숫자 여부 확인가능 ㅋ
 * 
 */
public class Solution1233 {
    static int n;
    static char[] data;

    public static boolean check(int x) {
        if (x > n)
            return true;
        // 탈출조건은 일단 말단이냐?! 체크해라
        if (x * 2 <= n || x * 2 + 1 <= n) {
            // 아직 나는 자식이 있는 부모노드다.
            if (Character.isDigit(data[x])) {
                // 근데 만약 숫자면?
                return false;
            } else {
                return check(x * 2) && check(x * 2 + 1);
            }
        } else {
            // 그렇다 말단이다. 그래 리프
            if (Character.isDigit(data[x])) {
                // 숫자면
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {

            n = sc.nextInt();
            sc.next();
            data = new char[n + 1];
            for (int j = 1; j <= n; j++) {
                String[] s = sc.nextLine().split(" ");
                data[j] = s[1].charAt(0);
            }
            System.out.println("#" + (i + 1) + " " + (check(1) ? 1 : 0));
        }
    }
}