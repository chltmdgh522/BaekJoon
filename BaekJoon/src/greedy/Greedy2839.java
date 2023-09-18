package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        while (true) {
            if(n%5==0){
                n=n/5;
                result+=n;
                break;
            }
            n=n-3;
            result++;
            if(n==0){
                break;
            }
            if(n<3){
                result=-1;
                break;
            }
        }

        System.out.println(result);

    }
}
