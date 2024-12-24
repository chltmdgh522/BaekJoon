package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long compare = arr[N - 1];
            long p_sum = 0;
            long cnt = 0;
            long sum = 0;
            boolean flag = false;
            for (int j = N - 2; j >= 0; j--) {
                if (compare < arr[j]) {
                    sum += compare * cnt - p_sum;
                    compare = arr[j];
                    p_sum = 0;
                    cnt = 0;
                    flag = true;
                } else {
                    flag = false;
                    p_sum += arr[j];
                    cnt++;
                }
            }

            if (!flag) {
                sum += compare * cnt - p_sum;
            }
            System.out.println(sum);
        }

    }
}
