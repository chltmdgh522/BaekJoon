package star;

import java.util.Scanner;

public class Star2446 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int a = num;
        for (int i = 0; i < num; i++) {
            for (int k = 0; k < i; k++) {
                sb.append(" ");
            }
            for (int j = 2 * a - 1; j > 0; j--) {
                sb.append("*");
            }
            a--;
            sb.append("\n");
        }
        a = 2;
        int b= num-1;
        for (int i = 0; i < num - 1; i++) {
            for (int k = 0; k < b - 1; k++) {
                sb.append(" ");
            }
            for (int j = 0; j < 2 * a - 1; j++) {
                sb.append("*");
            }
            b--;
            a++;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
