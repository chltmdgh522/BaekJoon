package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back15656 {

    static int n;

    static int m;

    static int[] num;
    static int[] result;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        backTracking(0);
        bw.flush();
        bw.close();
    }

    private static void backTracking(int depth) throws IOException {
        if (depth == m) {
            for (int i : result) {
                bw.write(i + " ");
            }
            bw.write("\n");
        } else {
            for (int i = 0; i < n; i++) {
                result[depth] = num[i];
                backTracking(depth + 1);

            }
        }
    }
}
