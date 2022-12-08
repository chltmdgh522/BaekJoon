package star;

import java.util.Scanner;

public class Star2523 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = s.nextInt();
        int star = 1;
        int starex = 1;
        for (int i = 0; i < 2 * num - 1; i++) {
            for (int j = 0; j < star; j++) {
                sb.append("*");
            }
            if (i == num - 1) {
                starex = -1;
            }
            star += starex;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
