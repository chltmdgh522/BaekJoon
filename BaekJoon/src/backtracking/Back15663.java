package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Back15663 {

    static int n;

    static int m;
    static int[] result;

    static int[] num;

    static boolean[] visit;

    static BufferedWriter bw;

    static Set<String> set;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        result = new int[m];
        visit = new boolean[n];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        backTracking(0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    private static int backTracking(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int a : result) {
                sb.append(a).append(" ");
            }
            set.add(sb.toString().trim());
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = num[i];
                backTracking(depth + 1);
                visit[i] = false;
            }
        }
        return 1;
    }
}
