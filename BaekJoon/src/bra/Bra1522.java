package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bra1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        char[] message = new char[original.length()];
        int min = Integer.MAX_VALUE;
        int a_size = 0;
        int all = original.length();

        for (int i = 0; i < original.length(); i++) {
            message[i] = original.charAt(i);
            if (original.charAt(i) == 'a') {
                a_size++;
            }
        }
        int temp_cnt = 0;
        int b_cnt = 0;

        for (int i = 0; i < all; i++) {
            for (int j = i; j < i + a_size; j++) {
                if (j >= all) {
                    temp_cnt++;
                    break;
                }
                if (message[j] == 'b') {
                    b_cnt++;
                }

            }
            if (temp_cnt != 0) {
                for (int k = 0; k < temp_cnt; k++) {
                    if (message[k] == 'b') {
                        b_cnt++;
                    }
                }
            }

            min = Math.min(min, b_cnt);
            b_cnt = 0;
        }
        System.out.println(min);
    }
}
