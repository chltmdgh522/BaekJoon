package bra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bra14501 {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMaxProfit(0));
    }


    public static int getMaxProfit(int day) {
        if(day>=n){
            return 0;
        }

        int p1=getMaxProfit(day+1);

        int p2=0;
        if(day+arr[day][0]<=n){
            p2=arr[day][1] + getMaxProfit(day+arr[day][0]);
        }

        return Math.max(p1,p2);
    }
}
