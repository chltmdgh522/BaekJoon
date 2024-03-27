package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Greedy17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s_ball = br.readLine();
        char[] ball = new char[n];

        for (int i = 0; i < n; i++) {
            ball[i] = s_ball.charAt(i);
        }

        char b_temp = ball[n - 1];
        char f_temp=ball[0];
        int f_cnt = 0;
        int finalB_cnt = 0;
        int b_cnt=0;
        int finalF_cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (b_temp == ball[i]) {
                b_cnt++;
            } else {
                break;
            }
        }

        for(int i=0; i<n; i++){
            if(f_temp==ball[i]) {
                f_cnt++;
            }else{
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (b_temp == ball[i]) {
                finalB_cnt++;
            }
            if(f_temp == ball[i]){
                finalF_cnt++;
            }
        }
        int b_cnt1 = finalB_cnt - b_cnt;
        int b_cnt2 = n - finalB_cnt;

        int f_cnt1 = finalF_cnt - f_cnt;
        int f_cnt2 = n - finalF_cnt;

        int b_max = Math.min(b_cnt1, b_cnt2);
        int f_max = Math.min(f_cnt1, f_cnt2);

        System.out.println(Math.min(b_max,f_max));

    }
}
