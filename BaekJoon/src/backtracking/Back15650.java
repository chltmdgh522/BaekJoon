package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back15650 {
    static int n;
    static int m;
    static boolean[] visit;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        arr = new int[m];
        dfs(0);
    }

    public static int dfs(int depth) {
        if (depth == m) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                if (depth == 0 || arr[depth - 1] < arr[depth]) {
                    dfs(depth + 1);
                }
                visit[i] = false;
            }
        }
        return 1;
    }
}
