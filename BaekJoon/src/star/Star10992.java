package star;

import java.util.Scanner;

public class Star10992 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = s.nextInt();
        int n = num;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < n - 1; j++) {
                sb.append(" ");
            }

            for (int k = 0; k < 1; k++) {
                sb.append("*");
            }
            if (i != num - 1) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    sb.append(" ");
                }
                for (int k = 0; k < 1; k++) {
                    if (i != 0) {
                        sb.append("*");
                    }
                }
                n--;
                sb.append("\n");
            }
            if (i == num - 1) {
                for (int k = 0; k < 2 * num - 2; k++) {
                    sb.append("*");
                }
            }
        }
        System.out.print(sb);

    }
}
