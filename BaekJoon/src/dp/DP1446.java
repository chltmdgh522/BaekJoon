package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP1446 {
    static int d;

    static int n;

    static int[][] road;

    static int min = Integer.MAX_VALUE;

    static int max = 0;

    static int length;

    static int final_length = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        road = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b <= d && b - a >= c) {
                road[i][0] = a;
                road[i][1] = b;
                road[i][2] = c;
                max = Math.max(a, max);
            } else {
                road[i][0] = 10001;
                road[i][1] = 10001;
                road[i][2] = 10001;
            }


        }


        solution(0, 0);
        if(min == Integer.MAX_VALUE){
            System.out.println(d);
        }else {
            System.out.println(min);
        }
    }

    private static void solution(int level, int end) {
        if (end > max) {
            final_length = d - end;
            length += final_length;

            min = Math.min(length, min);

            return;
        }
        for (int i = 0; i < n; i++) {
            if (road[i][0] >= end && road[i][0] != 10001 && road[i][1] != 10001 && road[i][2] != 10001) {
                int start = road[i][0];
                length += (start - end);

                length += road[i][2];
                solution(level + 1, road[i][1]);

                length -= (road[i][2] + (start - end) + final_length);
                final_length = 0;

            }
        }


    }
}
