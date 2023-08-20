package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Graph5567 {
    static int n;
    static int m;
    static int[][] connect;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        /**
         *BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
         *         StringTokenizer stk = new StringTokenizer(bfr.readLine());
         *         n = Integer.parseInt(stk.nextToken());
         *         m = Integer.parseInt(stk.nextToken());
         */

        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
        m = sc.nextInt();
        connect = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {

            //int x=Integer.parseInt(stk.nextToken());
            //int y=Integer.parseInt(stk.nextToken());
            int x = sc.nextInt();
            int y = sc.nextInt();
            connect[x][y] = connect[y][x] = 1;
        }
            visited[1] = true;
            bfs();
            System.out.println(visit());

    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int cnt = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

                for (int i = 1; i <= n; i++) {
                    if (connect[poll][i] == 1 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;

                    }
                }
            cnt++;
                if(cnt==2){
                    System.out.println("gd");
                    for(int i=0; i<queue.size(); i++){
                        queue.poll();
                    }
                }
            }
        }

    /**
     * 6
     * 5
     * 1 2
     * 1 3
     * 3 4
     * 2 3
     * 4 5
     * @return
     */

    public static int visit() {
        int cnt = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                cnt++;
            }
        }
        return cnt-1;
    }
}
