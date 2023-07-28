package onearray;

import java.util.Scanner;

public class OneArray10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[2];
        for (int i = 0; i < 2; i++) {
            num[i] = sc.nextInt();
        }
        int[] a = new int[num[0]];
        for (int i = 0; i < a.length; i++) {
            int num2 = sc.nextInt();
            a[i] = num2;
        }
        for (int j : a) {
            if (j < num[1]) {
                System.out.print(j+" ");

            }
        }
    }
}
