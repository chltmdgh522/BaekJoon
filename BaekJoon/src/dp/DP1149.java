package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[1001][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + Integer.parseInt(st.nextToken());
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + Integer.parseInt(st.nextToken());
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + Integer.parseInt(st.nextToken());
        }
        System.out.println(Math.min(dp[n][2], Math.min(dp[n][0], dp[n][1])));
    }
}
