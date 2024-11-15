package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph14502 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);

        System.out.println(max);
    }

    static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wall + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }


    static void bfs() {
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            } //Collections.sort(list, Collections.reverseOrder());//Integer.parseInt()
            // String.valueOf()
        }//static int min = Integer.MAX_VALUE;
        int[][] copyArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int staticX = temp[0];
            int staticY = temp[1];
            for (int i = 0; i < 4; i++) {
                int nextX = staticX + dx[i];
                int nextY = staticY + dy[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (copyArr[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        copyArr[nextX][nextY] = 2;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyArr[i][j] == 0) {
                    cnt++;
                }
            }
        }

        max = Math.max(max, cnt);
    }
}
