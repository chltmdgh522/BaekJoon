package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph1926 {

    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static int[][] arr;
    static boolean[][] visit;

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    cnt++;
                    int bfs = bfs(i, j);
                    max = Math.max(max, bfs);
                }
            }
        }


        System.out.println(cnt);
        System.out.println(max);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int staticX = poll[0];
            int staticY = poll[1];
            for (int i = 0; i < 5; i++) {
                int nextX = staticX + dx[i];
                int nextY = staticY + dy[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (arr[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                        visit[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
