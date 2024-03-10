package dp;

import java.io.*;

public class DP1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        int[] dp = new int[41];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < 41; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                bw.write("1 0");
                bw.write("\n");
            }else{
            bw.write(dp[n-1] + " " + dp[n]);
            bw.write("\n");
                }
        }
        bw.flush();
        bw.close();
    }

}
