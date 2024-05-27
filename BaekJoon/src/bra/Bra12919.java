package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bra12919 {
    static String s;

    static String t;

    static int len = 0;

    static StringBuilder sb;

    static boolean flag;

    static int correct = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        sb = new StringBuilder();
        sb.append(s);
        len = t.length() - s.length();

        dfs(0);
        System.out.println(correct);
    }

    private static int dfs(int level) {
        String string = sb.toString();
        if (string.equals(t)) {
            flag = true;
            correct = 1;
            return 1;
        }

        if (s.length() >= t.length()) {
            return 0;
        }

        for (int i = level; i < len; i++) {
            if (!flag) {
                sb.append('A');
                dfs(level + 1);
                String substring_a = sb.substring(0, sb.length() - 1);
                sb = new StringBuilder();
                sb.append(substring_a);
            }

            if (!flag) {
                StringBuilder b = sb.append('B');
                String bb = b.toString();
                sb = new StringBuilder();
                for (int j = b.length() - 1; j >= 0; j--) {
                    sb.append(bb.charAt(j));
                }
                dfs(level + 1);
                String substring_b = sb.substring(1, sb.length());
                sb = new StringBuilder();
                sb.append(substring_b);
            }
        }
        return 0;
    }
}
