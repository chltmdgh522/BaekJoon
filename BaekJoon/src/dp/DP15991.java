package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP15991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        long []dp=new long[100001];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=2;
        dp[4]=3;
        dp[5]=3;


        for(int i=0; i<t; i++){
            int n=Integer.parseInt(br.readLine());
            for(int j=6; j<n+1; j++){
                dp[j]=(dp[j-2]+dp[j-4]+dp[j-6])%1000000009;
            }
            System.out.println(dp[n]);
        }
    }
}
