package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];


        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i + 1; j++) {
                num[j] = Integer.parseInt(st.nextToken());
                if (i == 1) {
                    dp[1][1] = num[j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + num[j], dp[i - 1][j] + num[j]);
                }
            }
        }
        Arrays.sort(dp[n]);
        System.out.println(dp[n][n]);
    }
}
