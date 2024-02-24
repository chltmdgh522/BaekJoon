package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bra14889 {

    static int[][] arr;

    static int n;

    static int count = 0;

    static int booleanCount = 0;
    static boolean[] visit;

    static boolean[] result;

    static int min = Integer.MAX_VALUE;
    static int key = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        result = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(min);
    }

    private static int dfs(int depth) {
        if (booleanCount == n / 2) {
            solution();
            return 0;
        }
        if (depth == n) {
            return 1;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                dfs(depth + 1);
            } else if (!visit[depth + 1] && booleanCount < n / 2) {
                booleanCount++;
                visit[depth + 1] = true;
                dfs(depth + 1);
                visit[depth + 1] = false;
                booleanCount--;
            }
        }

        return 1;
    }

    private static void solution() {
        int fsum = 0;
        int tsum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visit[j] && !visit[i] && i != j) {
                    fsum += arr[i][j];
                } else if (visit[j] && visit[i] && i != j) {
                    tsum += arr[i][j];
                }
            }
        }
        int result = Math.abs(tsum - fsum);
        min = Math.min(min, result);
    }

}
