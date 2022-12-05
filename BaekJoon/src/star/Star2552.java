package star;

import java.util.Scanner;

public class Star2552 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int a = 1;
        int b = num - 1;
        for (int i = 0; i < num; i++) {
            for (int k = 0; k < b; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            a++;
            b--;
            System.out.print("\n");
        }
        a = num - 1;
        b = num - 2;
        for (int i = 0; i < num - 1; i++) {
            for (int k = 0; k < b; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            a--;
            b++;
            System.out.print("\n");
        }
    }
}


