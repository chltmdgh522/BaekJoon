package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String original = br.readLine();
        int all = original.length();

        int zero_cnt = 0;
        int one_cnt = 0;
        for (int i = 0; i < all; i++) {
            if (original.charAt(i) == '1') {
                one_cnt++;
            } else {
                zero_cnt++;
            }
            sb.append(original.charAt(i));
        }
        int f_one_cnt = one_cnt / 2;
        int f_zero_cnt = zero_cnt / 2;

        for(int i=0; i<all; i++){
            if(original.charAt(i)=='1' && f_one_cnt!=0){
                sb.setCharAt(i,'2');
                f_one_cnt--;
            }
        }

        for(int i=all-1; i>=0; i--){
            if(original.charAt(i)=='0' && f_zero_cnt !=0){
                sb.setCharAt(i,'2');
                f_zero_cnt--;
            }
        }

        String message=sb.toString();
        sb=new StringBuilder();
        for(int i=0; i<all; i++){
            if(message.charAt(i)!='2'){
                sb.append(message.charAt(i));
            }
        }

        System.out.println(sb.toString());


    }
}
