package greedy;

import java.util.Scanner;

/**
 * 10+ 12-
 */
public class Greedy1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] s1Minus = s.split("-");
        int sum = 0;
        int result = 0;
        for (int i = 0; i < s1Minus.length; i++) {
            sum = 0;
            String[] splitPlus = s1Minus[i].split("\\+");
            for (int j = 0; j < splitPlus.length; j++) {
                sum += Integer.parseInt(splitPlus[j]);
            }
            if (i == 0) {
                result = sum;

            } else {
                result -= sum;

            }

        }
        System.out.println(result);


    }
}
