package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph13913 {

    static int n;

    static int k;

    static boolean[] visit = new boolean[100001];

    static int[] dx = {-1, 1};

    static int[][] sign = new int[100001][1];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit[n] = true;
        bfs();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pos = poll[0];
            int move = poll[1];

            if (pos == k) {
                System.out.println(move);

                solution();
                list.add(n);
                Collections.reverse(list);
                for (Integer i : list) {
                    System.out.print(i + " ");
                }
                return;
            }

            if (pos * 2 >= 0 && pos * 2 <= 100000 && !visit[pos * 2]) {
                queue.offer(new int[]{pos * 2, move + 1});
                sign[pos * 2][0] = 2;
                visit[pos * 2] = true;
            }
            for (int i = 0; i < 2; i++) {
                if (pos + dx[i] >= 0 && pos + dx[i] <= 100000 && !visit[pos + dx[i]]) {
                    queue.offer(new int[]{pos + dx[i], move + 1});
                    sign[pos + dx[i]][0] = dx[i];
                    visit[pos + dx[i]] = true;
                }
            }
        }
    }


    private static void solution() {
        while (k != n) {
            list.add(k);
            int i = sign[k][0];
            if (i == -1) {
                k += 1;
            } else if (i == 1) {
                k -= 1;
            } else {
                k /= 2;
            }
        }
    }
}
