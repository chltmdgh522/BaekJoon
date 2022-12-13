package star;

import java.util.Scanner;

public class Star10990 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = s.nextInt();
        int a = num;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < a - 1; j++) {
                sb.append(" ");
            }
            for (int k = 0; k < 1; k++) {
                sb.append("*");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                sb.append(" ");
            }
            for (int k = 0; k < 1; k++) {
                if (i != 0) {
                    sb.append("*");
                }
            }
            a--;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
