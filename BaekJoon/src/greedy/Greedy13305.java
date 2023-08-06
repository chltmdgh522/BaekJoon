package greedy;

import java.util.Scanner;

public class Greedy13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] km = new long[n - 1];
        for (int i = 0; i < km.length; i++) {
            km[i] = sc.nextLong();
        }
        long[] money = new long[n];
        for (int i = 0; i < money.length; i++) {
            money[i] = sc.nextInt();
        }
        long result = problem(km, money);
        System.out.println(result);
    }

    private static int problem(long[] km, long[] money) {
        int result=0;
        long min = money[0];
        for (int i = 0; i < money.length - 1; i++) {
            min = Math.min(money[i], min);
            result+=min*km[i];
        }
        return result;
    }
}
