package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DP12101 {
    static int k;

    static int n;

    static int[] result;

    static int cnt = 0;

    static int k_cnt = 0;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        result = new int[12];

        back(1);
        int r_cnt = 0;
        if (!list.isEmpty()) {
            for (Integer i : list) {
                r_cnt++;
                System.out.print(i);
                if (r_cnt != k_cnt) {
                    System.out.print("+");
                }
            }
        } else {
            System.out.println(-1);
        }

    }

    private static int back(int depth) {
        if (cnt == k) {
            return 0;
        }
        int sum = 0;
        for (int tem : result) {
            sum += tem;
        }

        if (sum == n) {
            cnt++;
            if (cnt == k) {
                for (int i = 1; i < result.length; i++) {
                    if (result[i] != 0) {
                        k_cnt++;
                        list.add(result[i]);
                    }
                }
            }
            return 0;
        }
        if (sum > n) {
            return 0;
        }

        for (int i = 1; i < 4; i++) {
            result[depth] = i;
            back(depth + 1);
            result[depth] = 0;
        }

        return 1;
    }
}
