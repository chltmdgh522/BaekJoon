package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Greedy1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t;
        int n;
        int[][] rank;
        t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            n = Integer.parseInt(br.readLine());
            rank = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    rank[i][j] = Integer.parseInt(st.nextToken());

                }
            }
            logic(rank, n);
        }

    }

    static void logic(int[][] rank, int n) {
        Arrays.sort(rank, Comparator.comparingInt(o -> o[0]));
        int cnt = 1;
        int b = rank[0][1];

        for (int i = 1; i < n; i++) {
            if (b>rank[i][1]) {
                b = rank[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
