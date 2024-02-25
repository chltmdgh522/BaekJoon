package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2529 {
    static int k;

    static String[] sign;

    static int compare = 0;

    static long min = Long.MAX_VALUE;

    static long max = Integer.MIN_VALUE;

    static boolean[] visit;

    static StringBuilder sb;

    static String minNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        sign = new String[k];
        visit = new boolean[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken();
        }


        sb = new StringBuilder();
        dfs(0);
        System.out.println(max);
        System.out.println(minNumber);

    }

    private static int dfs(int depth) {
        if (depth == k + 1) {
            if (min > Long.parseLong(sb.toString())) {
                minNumber = sb.toString();
                min = Long.parseLong(sb.toString());
            }
            max = Math.max(max, Long.parseLong(sb.toString()));

            return 0;
        }

        for (int i = 0; i < 10; i++) {
            if (depth == 0) {
                compare = i;
                visit[i] = true;
                sb.append(compare);
                dfs(depth + 1);
                visit[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            } else if (!visit[i]) {
                if (sign[depth - 1].equals(">") && compare > i || sign[depth - 1].equals("<") && compare < i) {
                    logic(depth, i);
                }
            }
        }
        return 1;
    }

    private static void logic(int depth, int i) {
        compare = i;
        sb.append(compare);
        visit[i] = true;
        dfs(depth + 1);
        visit[i] = false;
        sb.deleteCharAt(sb.length() - 1);
        compare = Integer.parseInt(String.valueOf(sb.charAt(sb.length() - 1)));
    }
}
