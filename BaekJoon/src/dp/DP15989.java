package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP15989 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;

        int[][] dp = new int[10001][4];
        int t = Integer.parseInt(br.readLine());
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i=4; i<10001; i++){
            dp[i][1]=dp[i-1][1];
            dp[i][2]=dp[i-2][1]+dp[i-2][2];
            dp[i][3]=dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
        }
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][1]+dp[n][2]+dp[n][3]);
        }
    }

}

/*
*  static int n;

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            dp = new int[10001];
            Arrays.fill(dp, 1);
            n = Integer.parseInt(br.readLine());
            d_p();
        }
    }

    private static void d_p(){
        for (int i=2; i<n+1; i++){
            dp[i]+=dp[i-2];
        }

        for (int i=3; i<n+1; i++){
            dp[i]+=dp[i-3];
        }

        System.out.println(dp[n]);
    }*/