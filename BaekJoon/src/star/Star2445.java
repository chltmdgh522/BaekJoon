package star;

import java.util.Scanner;

public class Star2445 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int a = num;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.println("*");
            }
            for (int k = 0; k < 2 * a - 2; k++) {
                System.out.println(" ");
            }
            a--;
            for (int n = 0; n < i + 1; n++) {
                System.out.println("*");
            }

            System.out.println("\n");
        }
        a = 2;
        for (int i = num - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.println("*");
            }
            for (int k = 0; k < 2 * a - 2; k++) {
                System.out.println(" ");
            }
            a++;
            for (int n = 0; n < i; n++) {
                System.out.println("*");
            }
            System.out.println("\n");
        }


    }
}

