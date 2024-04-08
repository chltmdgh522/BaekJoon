package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph13549 {
    static int n;
    static int k;
    static boolean[] visit = new boolean[100001];
    static int[] dx = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pos = poll[0];
            int time = poll[1];

            if (pos == k) {
                System.out.println(time);
                return;
            }

            if (pos * 2 <= 100000 && !visit[pos * 2] ) {
                visit[pos * 2] = true;
                queue.offer(new int[]{pos * 2, time});
            }
            for (int i = 0; i < 2; i++) {
                if (pos + dx[i] <= 100000 && pos + dx[i] >= 0 && !visit[pos + dx[i]]) {
                    visit[pos + dx[i]] = true;
                    queue.offer(new int[]{pos + dx[i], time + 1});
                }
            }
        }
    }

}
