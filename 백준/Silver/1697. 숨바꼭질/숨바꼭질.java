
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    private static void bfs() {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        int pre_N = N;
        queue.add(pre_N);
        while (!visit[K]) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int pre_N2 = queue.poll();
                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        pre_N = pre_N2 - 1;
                    } else if (i == 1) {
                        pre_N = pre_N2 + 1;
                    } else {
                        pre_N = pre_N2 * 2;
                    }

                    if (pre_N >= 0 && pre_N <= 100000) {
                        if (!visit[pre_N]) {
                            visit[pre_N] = true;
                            queue.add(pre_N);
                        }
                    }
                }


            }

            cnt++;
        }
        System.out.println(cnt);
    }
}
