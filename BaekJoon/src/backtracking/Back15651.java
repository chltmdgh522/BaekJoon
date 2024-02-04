package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Back15651 {
    static int n;
    static int m;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dfs(0);
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth) throws IOException {
        if (depth == m) {
            for (int num : arr) {
                bw.write(num + " ");
            }
            bw.write("\n");
        } else {
            for (int i = 0; i < n; i++) {
                arr[depth] = i + 1;
                dfs(depth + 1);
            }

        }
    }
}
