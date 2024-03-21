package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bra1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int cnt = 0;
        int temp = 10;
        if (Integer.parseInt(n) < 10) {
            cnt = Integer.parseInt(n);
        } else {
            for (int i = 1; i < n.length(); i++) {
                cnt += 9 * (i + 1) * temp;
                temp *= 10;
            }
            int pos = temp - Integer.parseInt(n) - 1;
            int f_pos = pos * n.length();
            cnt = cnt - f_pos + 9;
        }

        System.out.println(cnt);
    }
}
