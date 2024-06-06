package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bra2531 {
    static int n;

    static int d;

    static int k;
    static int c;

    static int[] food;

    static List<Integer> list = new ArrayList<>();

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        food = new int[n];

        for (int i = 0; i < n; i++) {
            food[i] = Integer.parseInt(br.readLine());
            list.add(food[i]);
        }

        solution();
        System.out.println(max);
    }

    private static void solution() {
        boolean[] visit = new boolean[d+1];
        int cnt = 0;
        int start;


        for (int i = 0; i < n; i++) {
            start = list.get(0);
            for (int j = 0; j < k; j++) {
                if (!visit[list.get(j)]) {
                    visit[list.get(j)] = true;
                    cnt++;
                }
            }
            if (!visit[c]) {
                cnt++;
            }

            visit = new boolean[d + 1];
            list.remove(0);
            list.add(start);
            max = Math.max(cnt, max);
            cnt=0;
        }

    }


}
