package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph14940 {

    static int n;
    static int m;

    static int[][] arr;

    static boolean[][] visit;

    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visit[i][j]=true;
                    arr[i][j]=0;
                }
            }
        }

        bfs();



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]==1 && !visit[i][j]){
                    arr[i][j]=-1;
                }
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int sX = poll[0];
                int sY = poll[1];

                for (int i = 0; i < 4; i++) {
                    int nX = sX + dx[i];
                    int nY = sY + dy[i];
                    if (nX >= 0 && nX < n && nY >= 0 && nY < m) {
                        if (arr[nX][nY] != 0 && !visit[nX][nY]) {
                            arr[nX][nY] += cnt;
                            visit[nX][nY] = true;
                            queue.add(new int[]{nX, nY});
                        }
                    }
                }
            }
            cnt++;
        }
    }
}
