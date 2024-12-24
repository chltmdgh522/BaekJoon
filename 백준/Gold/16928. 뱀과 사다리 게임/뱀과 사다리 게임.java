import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int M;

    static int[][] map = new int[101][1];

    static boolean[] visit = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][0] = y;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u][0] = v;
        }


        int bfs = bfs();
        System.out.println(bfs);
    }

    private static int bfs() {
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {

            cnt++;
            for (int j = 0, size = queue.size(); j < size; j++) {

                int temp = queue.poll();

                for (int i = 1; i < 7; i++) {
                    int value=0;
                    if (map[temp + i][0] != 0 && !visit[temp + i]) {
                        value = map[temp + i][0];
                        queue.add(map[temp + i][0]);
                    } else {
                        if (temp + i <= 100 && !visit[temp+i]) {
                            value = temp + i;
                            queue.add(temp + i);
                        }
                    }

                    visit[temp]=true;
                    if (value == 100) {
                        return cnt;
                    }
                }
            }

        }
        return 0;
    }
}
