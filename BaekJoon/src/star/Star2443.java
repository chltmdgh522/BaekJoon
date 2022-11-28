package star;

import java.util.Scanner;

public class Star2443 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        int a = num - 1;
        int c = 0;
        for (int i = 0; i < num; i++) {
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