package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Back14888 {
    static int n;

    static int[] num;
    static int[] sign;

    static int[] result;
    static BufferedWriter bw;

    static int min = Integer.MAX_VALUE;

    static int max = Integer.MIN_VALUE;
    static int finalResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        num = new int[n];
        sign = new int[4];
        result = new int[n - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sign[i] = Integer.parseInt(st.nextToken());
        }

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        backTracking(0);
        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    static int backTracking(int depth) {
        if (depth == n - 1) {
            finalResult = num[0];
            int calculation = calculation();
            max = Math.max(max, calculation);
            min = Math.min(min, calculation);
            return 0;
        }

        for (int i = 0; i < sign.length; i++) {
            if (sign[i] != 0) {
                sign[i] -= 1;
                result[depth] = i;
                backTracking(depth + 1);
                sign[i] += 1;
            }
        }
        return 1;
    }

    public static int calculation() {
        for (int i = 1; i < num.length; i++) {
            if (result[i - 1] == 0) {
                finalResult = finalResult + num[i];
            }
            if (result[i - 1] == 1) {
                finalResult = finalResult - num[i];
            }
            if (result[i - 1] == 2) {
                finalResult = finalResult * num[i];
            }
            if (result[i - 1] == 3) {
                finalResult = finalResult / num[i];
            }
        }

        return finalResult;
    }
}
