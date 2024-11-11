import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int[][] arr;
    static boolean[][] visit;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<int[]> queue;

    static int n = 0;

    static int[][] arr2;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            arr2 = new int[n][n];

            for (int[] ints : arr2) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }

            visit = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                String text = br.readLine();
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(text.substring(k, k + 1));
                }
            }

            int num = i + 1;
            queue = new LinkedList<>();
            visit[0][0] = true;
            queue.add(new int[]{0, 0, 0});
            solution();
            System.out.println("#" + num + " " + arr2[n - 1][n - 1]);
        }
    }

    private static void solution() {

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int sx = poll[0];
            int sy = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int dist = poll[2];
                    int nd = dist + arr[nx][ny];

                    if (arr2[nx][ny] > nd) {
                        arr2[nx][ny] = nd;
                        queue.add(new int[]{nx, ny, nd});
                    }
                }
            }
        }
    }
}
