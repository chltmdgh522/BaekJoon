package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

public class Bra3085 {

    static int n;
    static int max = 0;
    static char[][] arr;

    static boolean[][] visit;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String message = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = message.charAt(j);
            }
        }

        swap();
        bfs();
        if (max == 0) {
            System.out.println(n);
        } else {
            System.out.println(max);
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int sX = poll[0];
            int sY = poll[1];

            for (int i = 0; i < 2; i++) {
                int nX = sX + dx[i];
                int nY = sY + dy[i];

                if (nX >= 0 && nX < n && nY >= 0 && nY < n) {
                    if (arr[nX][nY] != arr[sX][sY]) {
                        char temp = arr[nX][nY];
                        arr[nX][nY] = arr[sX][sY];
                        arr[sX][sY] = temp;

                        swap();

                        char temp1 = arr[sX][sY];
                        arr[sX][sY] = arr[nX][nY];
                        arr[nX][nY] = temp1;

                        if (max == n) {
                            return;
                        }
                    }
                    if (!visit[nX][nY]) {
                        queue.add(new int[]{nX, nY});
                    }
                    visit[nX][nY] = true;

                }
            }

        }
    }

    private static void swap() {
        int max_w = 0;
        int max_1w = 0;

        for (int i = 0; i < n; i++) {
            int max_1 = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    max_1++;
                    max_1w = Math.max(max_1w, max_1);
                } else {
                    max_1w = Math.max(max_1w, max_1);
                    max_1 = 1;
                }
            }

            max_w = Math.max(max_1w, max_w);
        }


        int max_h = 0;
        int max_2h = 0;
        for (int i = 0; i < n; i++) {
            int max_2 = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    max_2++;
                    max_2h = Math.max(max_2h, max_2);
                } else {
                    max_2h = Math.max(max_2h, max_2);
                    max_2 = 1;
                }
            }
            max_h = Math.max(max_2h, max_h);
        }
        max = Math.max(max, Math.max(max_h, max_w));
    }
}