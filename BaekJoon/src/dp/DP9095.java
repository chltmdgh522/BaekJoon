package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        int dp[]=new int[11];
        for (int i = 0; i < t; i++) {
            int n=Integer.parseInt(br.readLine());
            dp[0]=0;
            dp[1]=1;
            dp[2]=2;
            dp[3]=4;

            for(int j=4; j<n+1; j++){
                dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
            }
            System.out.println(dp[n]);
        }
    }
}
