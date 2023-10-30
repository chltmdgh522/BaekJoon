package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = String.valueOf(br.readLine());
        int[] alphabet = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            alphabet[sentence.charAt(i) - 'A'] += 1;
        }
        char[] result = new char[sentence.length()];
        int front_p = 0;
        int cnt = 0;
        int rear_p = sentence.length() - 1;
        cnt = solution(sentence, alphabet, result, front_p, cnt, rear_p);
        if (cnt != 2) {
            for (char c : result) {
                System.out.print(c);
            }
        }
    }

    private static int solution(String sentence, int[] alphabet, char[] result, int front_p, int cnt, int rear_p) {
        int num;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                num = alphabet[i];
                int size = num / 2;
                for (int front = 0; front < size; front++) {
                    result[front_p] = (char) ((char) i + 'A');
                    front_p++;
                }
                for (int rear = size; rear > 0; rear--) {
                    result[rear_p] = (char) ((char) i + 'A');
                    rear_p--;
                }
                if (num % 2 == 1) {
                    int middle = sentence.length() / 2;
                    result[middle] = (char) ((char) i + 'A');
                    if (cnt != 0) {
                        System.out.println("I'm Sorry Hansoo");
                        cnt = 2;
                        break;
                    }
                    cnt = 1;
                }
            }
        }
        return cnt;
    }

}
