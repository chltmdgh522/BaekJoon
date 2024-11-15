package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1244 {
    static int[] num;
    static int max;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i < t + 1; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            num = new int[text.length()];
            for (int j = 0; j < text.length(); j++) {
                num[j] = Integer.parseInt(text.substring(j, j + 1));
            }
            int n = Integer.parseInt(st.nextToken());

            if (num.length < n) {
                n = num.length;
            }
            max = 0;
            solution(n, 0);
            System.out.println("#" + i + " " + max);
        }
    }

    private static void solution(int n, int depth) {

        if (depth == n) {
            String text = "";
            for (int i = 0; i < num.length; i++) {
                text += num[i];
            }
            max = Math.max(max, Integer.parseInt(text));
            return;
        }


        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                swap(i, j);
                solution(n, depth + 1);
                swap(i, j);

            }
        }

    }

    public static void swap(int i, int j) {
        int temp = 0;

        temp = num[i];
        num[i] = num[j];
        num[j] = temp;

    }
}
