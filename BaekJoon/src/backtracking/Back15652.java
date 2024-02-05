package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Back15652 {
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

    public static int dfs(int depth) throws IOException {
        if (depth == m) {
            for (int num : arr) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return 0;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            if (depth == 0 || arr[depth - 1] <= arr[depth]) {
                dfs(depth + 1);
            }
        }
        return 1;
    }

}
