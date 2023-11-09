package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph7576 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt1 = 0;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    cnt1++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }

        int result = bfs();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }
        if (count != 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    static int bfs() {
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] temp = queue.poll();
                int staticX = temp[0];
                int staticY = temp[1];
                for (int i = 0; i < 4; i++) {
                    int nextX = staticX + dx[i];
                    int nextY = staticY + dy[i];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                        if (arr[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                            visited[nextX][nextY] = true;
                            arr[nextX][nextY] = 1;
                            queue.add(new int[]{nextX, nextY});
                        }
                    }
                }

            }
            cnt++;
        }

        return cnt - 1;
    }
}
