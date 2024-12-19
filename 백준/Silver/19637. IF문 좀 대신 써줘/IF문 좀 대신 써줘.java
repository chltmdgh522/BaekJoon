
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] title = new String[N];
        int[] title_score = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            title_score[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 0; i < M; i++) {
            int war = Integer.parseInt(br.readLine());

            int start = 0;
            int end = N - 1;


            while (start <= end) {
                int mid = (start + end) / 2;
                if (title_score[mid] < war) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            sb.append(title[start]).append("\n");
        }

        System.out.println(sb.toString().trim());

    }
}
