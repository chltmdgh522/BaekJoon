package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph1012 {
    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x, y;
        int t;
        int cnt;
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            visited = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                y = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            cnt=0;
            for (int p = 0; p < n; p++) {
                for (int j = 0; j < m; j++) {
                    if (arr[p][j] == 1 && !visited[p][j]) {
                        visited[p][j] = true;
                        bfs(p, j);
                        cnt++;

                    }
                }
            }
            System.out.println(cnt);
        }

    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int staticX = poll[0];
            int staticY = poll[1];
            for (int k = 0; k < 4; k++) {
                int staticNX = staticX + dx[k];
                int staticNY = staticY + dy[k];
                if (staticNX >= 0 && staticNX < n && staticNY >= 0 && staticNY < m) {
                    if (arr[staticNX][staticNY] == 1 && !visited[staticNX][staticNY]) {
                        visited[staticNX][staticNY] = true;
                        queue.add(new int[]{staticNX,staticNY});
                    }
                }
            }
        }
    }
}
