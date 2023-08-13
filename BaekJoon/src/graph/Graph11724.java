package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph11724 {
    static int n;
    static int m;
    static int[][] connect;
    static boolean[] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        connect = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
           int x = sc.nextInt();
            int y = sc.nextInt();
            connect[x][y] = connect[y][x] = 1;
        }

        System.out.println(problem());
    }
    static int problem(){
        int cnt=0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                bfs(i);
                cnt++;
            }
        }
        return cnt;
    }

    static void bfs(int j) {
        Queue<Integer> queue = new LinkedList<>();
        visited[j] = true;
        queue.offer(j);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (connect[temp][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
