package star;

import java.util.Scanner;

public class Star2442 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int a = num;

        for (int i = 0; i < num; i++) {
            for (int k = (a-1); k > 0; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (i + 1) - 1; j++) {
                System.out.print("*");
            }
            a--;
            System.out.print("\n");


        }

    }
}
