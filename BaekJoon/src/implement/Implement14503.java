package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Implement14503 {

    static int n;

    static int m;

    static int x;

    static int y;

    static int direction;

    static int dx = 0;

    static int dy = 0;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, x, y);


    }

    private static void dfs(int depth, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int sX = poll[0];
            int sY = poll[1];

            direct();
            int nX = sX + dx;
            int nY = sY + dy;

            if (arr[nX][nY] != 1) {
                queue.add(new int[]{nX, nY});

            } else {
                if (direction == 0) {
                    direction += 3;
                } else {
                    direction -= 1;
                }
                direct();
                nX = sX + dx;
                nY = sX + dy;
            }
        }
    }

    private static void direct() {
        switch (direction) {
            case 0:
                dx = -1;
                dy = 0;
                break;
            case 1:
                dx = 0;
                dy = 1;
                break;
            case 2:
                dx = 1;
                dy = 0;
                break;
            case 3:
                dx = 0;
                dy = -1;
                break;
        }
    }
}
