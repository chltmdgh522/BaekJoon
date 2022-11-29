package star;

import java.util.Scanner;

public class Star2444 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        int c = 1;
        int a = num;

        for (int i = 0; i < num; i++) {
            for (int k = (a - 1); k > 0; k--) {
                System.out.println(" ");
            }
            for (int j = 0; j < 2 * (i + 1) - 1; j++) {
                System.out.println("*");
            }
            a--;
            System.out.println("\n");
        }
        a = num - 2;
        for (int i = 0; i < num - 1; i++) {
            for (int k = 0; k < c; k++) {
                System.out.println(" ");
            }
            for (int j = 0; j < 2 * (a + 1) - 1; j++) {
                System.out.println("*");
            }
            c++;
            a--;
            System.out.println("\n");
        }
    }
}
