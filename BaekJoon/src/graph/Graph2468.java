package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph2468 {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static List<Integer> list = new ArrayList<>();

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int height = 0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= height) {
                    height = arr[i][j];
                }
            }
        }


        int max = 0;

        for (int l = 0; l < height+1; l++) {
            System.out.println(l);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] >l && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j, l);
                        cnt++;
                    }
                }

            }
            visited = new boolean[n][n];
            max = Math.max(max, cnt);
            cnt = 0;
        }
        System.out.println(max);


    }

    static void bfs(int i, int j, int l) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int staticX = poll[0];
            int staticY = poll[1];


            for (int k = 0; k < 4; k++) {
                int staticNextX = staticX + dx[k];
                int staticNextY = staticY + dy[k];
                if (staticNextX >= 0 && staticNextX < n && staticNextY >= 0 && staticNextY < n) {
                    if (arr[staticNextX][staticNextY] > l && !visited[staticNextX][staticNextY]) {
                        queue.add(new int[]{staticNextX, staticNextY});
                        visited[staticNextX][staticNextY] = true;
                    }
                }
            }
        }
    }
}
