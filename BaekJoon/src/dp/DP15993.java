package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP15993 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[100001][3];

        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 2;
        dp[3][2] = 2;

        for (int i = 4; i < 100001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 2][2] + dp[i - 3][2]) % 1000000009;
            dp[i][2] = (dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1]) % 1000000009;
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][1] + " " + dp[n][2]);
        }
    }
}
