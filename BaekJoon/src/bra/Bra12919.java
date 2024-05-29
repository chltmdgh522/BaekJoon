package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bra12919 {
    static String s;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        String t = br.readLine();

        dfs(t);
        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(String message) {
        if (message.length() == s.length()) {
            if (message.equals(s)) {
                flag = true;
            }
            return;
        }

        if (message.endsWith("A")) {
            dfs(message.substring(0, message.length() - 1));
        }
        if (message.startsWith("B")) {
            dfs(new StringBuilder(message.substring(1)).reverse().toString());
        }

    }
}

/*
* package bra;

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
                sb.append('B');
                sb.reverse();
                dfs(level + 1);
                String substring_b = sb.substring(1, sb.length());
                sb = new StringBuilder();
                sb.append(substring_b);
            }
        }
        return 0;
    }
}
*/
