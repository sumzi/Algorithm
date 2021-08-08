# List

## **1228. 암호문1**

> 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.

### ✏️ **문제 풀이**
- 원본 암호문의 길이 만큼 list에 add해준다.
- 명령어의 개수를 입력 받아 for문을 돌리면서 I(삽입) 을 만났을때 for를 사용하여 x부터 x+y까지 y개의 숫자를 해당 위치에 삽입해준다.
- list 0부터 9까지 저장되어 있는 10개 숫자를 출력해준다.

### 💻 **소스 코드**
```java
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1228 {
    static int n, m, x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> code = new LinkedList<>();

        for (int t = 0; t < 10; t++) {
            code.clear();
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                code.add(sc.nextInt());
            }
            m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                sc.next();
                x = sc.nextInt();
                y = sc.nextInt();
                for (int j = x; j < x + y; j++) {
                    code.add(j, sc.nextInt());
                }
            }
            System.out.print("#" + (t + 1));
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + code.get(i));
            }
            System.out.println();
        }

    }
}
```

<br>

## **1229. 암호문2**

> 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.

### ✏️ **문제 풀이**
- 원본 암호문의 길이 만큼 list에 add해준다.
- 명령어의 개수를 입력 받아 for문을 돌린다. 
- I(삽입) 을 만났을때 x값부터 x+y까지 for을 순차적으로 반복하면서 y개의 숫자를 해당 위치에 삽입해준다.
- D(삭제) 를 만났을때 list x의 위치에 저장되어 있는 숫자를 for문을 사용하여 y개 삭제한다.
- list 0부터 9까지 저장되어 있는 10개 숫자를 출력해준다.

### 💻 **소스 코드**
```java
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1229 {
    static int n, m, x, y;
    static String c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> code = new LinkedList<>();

        for (int t = 0; t < 10; t++) {
            code.clear();
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                code.add(sc.nextInt());
            }
            m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                c = sc.next();
                x = sc.nextInt();
                y = sc.nextInt();
                if (c.equals("I")) {
                    for (int j = x; j < x + y; j++) {
                        code.add(j, sc.nextInt());
                    }
                } else if (c.equals("D")) {
                    for (int j = 0; j < y; j++) {
                        code.remove(x);
                    }
                }

            }
            System.out.print("#" + (t + 1));
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + code.get(i));
            }
            System.out.println();
        }

    }
}

```

<br>

## **1230. 암호문3**

> 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.

### ✏️ **문제 풀이**
- 원본 암호문의 길이 만큼 list에 add해준다.
- 명령어의 개수를 입력 받아 for문을 돌린다. 
- I(삽입) 를 만났을때 x값부터 x+y까지 for을 순차적으로 반복하면서 y개의 숫자를 해당 위치에 삽입해준다.
- D(삭제) 를 만났을때 list x의 위치에 저장되어 있는 숫자를 for문을 사용하여 y개 삭제한다.
- A(추가) 를 만났을때 list 맨 뒤에 for문을 사용하여 y개의 숫자를 add해준다.
- list 0부터 9까지 저장되어 있는 10개 숫자를 출력해준다.

### 💻 **소스 코드**
```java
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1230 {
    static int n, m, x, y;
    static String c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> code = new LinkedList<>();

        for (int t = 0; t < 10; t++) {
            code.clear();
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                code.add(sc.nextInt());
            }
            m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                c = sc.next();
                x = sc.nextInt();
                if (c.equals("I")) {

                    y = sc.nextInt();
                    for (int j = x; j < x + y; j++) {
                        code.add(j, sc.nextInt());
                    }
                } else if (c.equals("D")) {

                    y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        code.remove(x);
                    }
                } else if (c.equals("A")) {
                    for (int j = 0; j < x; j++) {
                        code.add(sc.nextInt());
                    }
                }
            }
            System.out.print("#" + (t + 1));
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + code.get(i));
            }
            System.out.println();
        }

    }
}

```
