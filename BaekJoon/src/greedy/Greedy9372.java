package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Greedy9372 {
    static int t;
    static int n;
    static int m;
    static int a;
    static int b;

    static boolean[] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            visit = new boolean[n + 1];
            arr = new int[n + 1][n + 1];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                arr[a][b] = arr[b][a] = 1;
            }
            System.out.println(bfs());
        }
    }

    public static int bfs() {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[temp][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                    cnt++;
                }
            }

        }
        return cnt;
    }
}
