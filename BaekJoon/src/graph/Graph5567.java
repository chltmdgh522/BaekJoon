package graph;
import java.util.*;

public class Graph5567 {
    static int n;
    static int m;
    static int[][] connect;
    static boolean[] visited;

    public static void main(String[] args){
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
        visited[1] = true;
        bfs();

    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(1);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int poll = queue.poll();
                for (int i = 1; i <= n; i++) {
                    if (connect[poll][i] == 1 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                        list.add(i);
                    }
                }
            }
            cnt++;
            if (cnt == 2) {
                break;
            }
        }
        System.out.println(list.size());
    }
}
