package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph4963 {

    static int n;

    static int m;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int temp = 0;
            temp = n;
            n = m;
            m = temp;
            if (n == 0 && m == 0) {
                break;
            }
            arr = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static int bfs(int i, int j) {
        int cnt = 0;
        cnt++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int staticX = poll[0];
            int staticY = poll[1];

            for (int k = 0; k < 8; k++) {
                int nextStaticX = staticX + dx[k];
                int nextStaticY = staticY + dy[k];
                if (nextStaticX >= 0 && nextStaticX < n && nextStaticY >= 0 && nextStaticY < m) {
                    if (arr[nextStaticX][nextStaticY] == 1 && !visited[nextStaticX][nextStaticY]) {
                        visited[nextStaticX][nextStaticY] = true;
                        queue.add(new int[]{nextStaticX, nextStaticY});

                    }
                }
            }
        }

        return cnt;
    }
}
