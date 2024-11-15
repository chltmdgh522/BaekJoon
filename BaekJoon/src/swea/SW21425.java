package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW21425 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(solution(x, y, n));
        }
    }

    private static int solution(int x, int y, int n) {
        int answer = 0;

        while (true) {
            answer++;
            if (x > y) {
                y += x;

            } else {
                x += y;
            }
            if (x > n || y>n) {
                break;
            }

        }

        return answer;
    }
}
