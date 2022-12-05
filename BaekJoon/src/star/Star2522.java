package star;

import java.util.Scanner;

public class Star2522 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int space = num - 1;
        int star = 1;
        int starex = 1;
        int spaceex = -1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num * 2 - 1; i++) {
            for (int j = 0; j < space; j++) {
                sb.append(" ");
            }
            for (int k = 0; k < star; k++) {
                sb.append("*");
            }
            if (star == num) {
                starex = -1;
                spaceex = 1;
            }
            star += starex;
            space += spaceex;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}


