package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bra16943 {

    static String a;
    static int b;
    static int c;
    static int max = 0;
    static int[] num;
    static int[] result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = String.valueOf(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        num = new int[a.length()];
        result = new int[a.length()];
        visit = new boolean[a.length()];

        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(String.valueOf(a.charAt(i)));
        }

        dfs(0);

        if (max == 0) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }

    private static int dfs(int depth) {
        if (depth == num.length) {
            StringBuilder sb = new StringBuilder();
            for (int i : result) {
                sb.append(i);
            }
            c = Integer.parseInt(String.valueOf(sb));
            if (c < b && c != Integer.parseInt(a)) {
                max = Math.max(max, c);
            }
            return 1;
        }

        for (int i = 0; i < num.length; i++) {
            if (!visit[i]) {
                if(depth ==0 && num[i] ==0){
                    continue;
                }
                visit[i] = true;
                result[depth] = num[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
        return 0;
    }
}
