package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bra1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = String.valueOf(st.nextToken());
        String b = String.valueOf(st.nextToken());
        int cnt = (b.length() - a.length());
        String a_finalSentence;
        int minus;
        int min = b.length();
        if (cnt == 0) {
            minus=0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    minus++;
                }
            }
            System.out.println(minus);

        } else {
            for (int i = 0; i < cnt + 1; i++) {
                a_finalSentence = b.substring(0, i) + a + b.substring(a.length() + i);
                minus = 0;
                for (int j = 0; j < a_finalSentence.length(); j++) {
                    if (a_finalSentence.charAt(j) != b.charAt(j)) {
                        minus++;
                    }
                }
                min = Math.min(minus, min);
            }
            System.out.println(min);
        }
    }
}
