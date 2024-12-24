import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        String line = br.readLine();
        char[] arr = line.toCharArray();

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                int startIndex = Math.max(i - K, 0);
                int endIndex = Math.min(i + K, N-1);

                for (int j = startIndex; j <= endIndex; j++) {
                    if (arr[j] == 'H') {
                        cnt++;
                        arr[j] = 'X';
                        break;
                    }
                }

            }
        }

        System.out.println(cnt);

    }
}
