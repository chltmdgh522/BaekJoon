package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int money=Integer.parseInt(st.nextToken());
        int []coin=new int[n];
        for(int i=0; i<n; i++){
            coin[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);
        int share=0;
        int remain;
        for(int i=n-1; i>=0; i--){
            if(money%coin[i]!=money){
                share+=money/coin[i];
                remain=money%coin[i];
                money=remain;
                if(remain==0){
                    break;
                }
            }
        }
        System.out.println(share);

    }
}
