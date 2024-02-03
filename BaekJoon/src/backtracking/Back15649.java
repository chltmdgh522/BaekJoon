package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back15649 {
    static int n;
    static int m;

    static boolean[] visit;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        num = new int[m];
        dfs(0);
    }

    public static int dfs(int cnt) {
        if (cnt == m) {
            for (int j : num) {
                System.out.print(j + " ");
            }
            System.out.println();
            cnt = 0;
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                num[cnt] = i + 1;
                dfs(cnt + 1);
                visit[i] = false;
            }
        }
        return 1;
    }
}
