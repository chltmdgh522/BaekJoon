package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Implement2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] word_arr = new int[26];
        int[] compare_arr;
        int cnt = 0;
        int answer = 0;
        String word = "";
        String compare = "";
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                word = br.readLine();
                for (int j = 0; j < word.length(); j++) {
                    word_arr[word.charAt(j) - 65] += 1;
                }
            } else {
                compare_arr = word_arr.clone();
                compare = br.readLine();
                if (Math.abs(word.length() - compare.length()) > 1) {
                    continue;
                }
                cnt = 0;

                for (int k = 0; k < compare.length(); k++) {
                    int index = compare.charAt(k) - 65;

                    if (compare_arr[index] > 0) {
                        cnt++;
                        compare_arr[index]--;
                    }
                }

                if (word.length() - 1 == compare.length()) {
                    if (cnt == compare.length()) {
                        answer++;
                    }

                } else if (word.length() + 1 == compare.length()) {
                    if (cnt == word.length()) {
                        answer++;
                    }
                } else if (word.length() == compare.length()) {
                    if (cnt == word.length()) {
                        answer++;
                    } else if (cnt == word.length() - 1) {
                        answer++;
                    }
                }
            }


        }

        System.out.println(answer);
    }
}
