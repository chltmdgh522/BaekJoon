package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph12851 {

    static int n;
    static int k;
    static int[] dx = {1, -1};

    static int min = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(min);
        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pos = poll[0];
            int time = poll[1];

            if (pos == k) {
                if (cnt == 0) {
                    min = time;
                }
                if (min == time) {
                    cnt++;
                }else{
                    return;
                }

            }
            if (pos * 2 <= 100000) {
                queue.add(new int[]{pos * 2, time + 1});
            }
            for (int i = 0; i < 2; i++) {
                if (pos + dx[i] >= 0 && pos + dx[i] <= 100000) {
                    queue.add(new int[]{pos + dx[i], time + 1});

                }
            }
        }
    }
}
