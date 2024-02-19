package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Back16922 {
    static int n;

    static int[] num = {1, 5, 10, 50};

    static int[] result;

    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n];
        set = new LinkedHashSet<>();
        dfs(0);
        System.out.println(set.size());
    }


    private static int dfs(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int a : result) {
                sum += a;
            }
            set.add(sum);
            return 1;
        }

        for (int j : num) {
            if (depth == 0 || result[depth - 1] <= j) {
                result[depth] = j;
                dfs(depth + 1);
            }
        }
        return 0;
    }
}
