package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph16929 {
    static int n;

    static int m;

    static char[][] graph;

    static boolean[][] visit;

    static int startX;
    static int startY;

    static char alphabet;

    static String message = "No";

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = row.charAt(j);
            }
        }
        outerLoop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit = new boolean[n][m];
                visit[i][j] = true;
                startX = i;
                startY = j;
                alphabet = graph[i][j];
                dfs(0, i, j);
                if (message.equals("Yes")) {
                    break outerLoop;
                }

            }
        }

        System.out.println(message);

    }

    private static void dfs(int depth, int staticX, int staticY) {
        for (int i = 0; i < 4; i++) {
            int nextX = dx[i] + staticX;
            int nextY = dy[i] + staticY;
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && alphabet == graph[nextX][nextY]) {
                if (!visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    dfs(depth + 1, nextX, nextY);
                } else {
                    if (depth >= 3 && nextX == startX && nextY == startY) {
                        message = "Yes";

                    }
                }
            }
        }
    }
}
