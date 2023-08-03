package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        problem(n, weight);
    }

    private static void problem(int n, int[] weight) {
        Arrays.sort(weight);
        int cnt = n;
        int min = 0;
        int result = 0;
        int finalResult = 0;
        for (int i = 0; i < n; i++) {
            result = weight[i] * cnt;
            if (min < result) {
                finalResult = result;
                min = result;
            }
            cnt--;
        }
        System.out.println(finalResult);
    }
}
