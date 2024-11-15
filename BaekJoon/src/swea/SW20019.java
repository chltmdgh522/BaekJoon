package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW20019 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String text = br.readLine();
            int num = i + 1;
            System.out.println("#" + num + " " + solution(text));
        }
    }

    static String solution(String text) {
        String answer = "";
        int length = text.length();
        int same = 0;
        if (length % 2 == 0) {
            same = length / 2;
            String back_text = text.substring(same);
            String front_text = text.substring(0, same);
            String re_back_text = new StringBuilder(back_text).reverse().toString();
            if (re_back_text.equals(front_text)) {
                if (new StringBuilder(front_text).reverse().toString().equals(front_text) && new StringBuilder(back_text).reverse().toString().equals(back_text)) {
                    answer = "YES";
                } else {
                    answer = "NO";
                }
            } else {
                answer = "NO";
            }

        } else {

            same = length / 2 + 1;
            String back_text = text.substring(same);
            String front_text = text.substring(0, same - 1);
            String re_back_text = new StringBuilder(back_text).reverse().toString();

            if (re_back_text.equals(front_text)) {
                if (new StringBuilder(front_text).reverse().toString().equals(front_text) && new StringBuilder(back_text).reverse().toString().equals(back_text)) {
                    answer = "YES";
                } else {
                    answer = "NO";
                }
            } else {
                answer = "NO";
            }

        }
        return answer;
    }
}
