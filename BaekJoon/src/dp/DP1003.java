package dp;

import java.io.*;

public class DP1003 {
    static int zcnt;

    static int ocnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] num = new int[t];
        int[] dp = new int[41];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(br.readLine());
            fibonacci(num[i]);
            bw.write(zcnt + " " + ocnt);
            bw.write("\n");
            zcnt=ocnt=0;

        }

        bw.flush();
        bw.close();
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            zcnt++;
            return 0;
        } else if (n == 1) {
            ocnt++;
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
