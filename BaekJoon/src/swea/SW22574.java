package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class SW22574 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            System.out.println(solution(n, p));
        }
    }

    private static int solution(int n, int p) {
        int answer = 0;
        int sum = IntStream.rangeClosed(1, n).sum();

        if (sum < p) {
            answer = sum;
        } else {
            for (int i = 1; i <= n; i++) {
                if (answer + i != p) {
                    answer += i;
                } else {
                    answer = sum - 1;
                    break;
                }
            }
        }
        return answer;
    }
}
