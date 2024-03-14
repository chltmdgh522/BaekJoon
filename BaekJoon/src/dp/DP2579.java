package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[301];
        int[] score = new int[301];

        for (int i = 1; i < n + 1; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        if (n >= 3) {
            dp[3] = Math.max(score[1], score[2]) + score[3];

        }
        for (int i = 4; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(dp[n]);

    }
}
