package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph2644 {
    static int n;
    static int r;
    static boolean[] visited;

    static int[] twoPeople = new int[2];
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int x, y;
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        arr = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            twoPeople[i] = Integer.parseInt(st.nextToken());
        }
        r = Integer.parseInt(br.readLine());


        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        for (int j = 0; j < n + 1; j++) {
            if (arr[twoPeople[0]][j] == 1 && !visited[j]) {
                visited[twoPeople[0]] = true;
                System.out.println(bfs(j));
                break;
            }
        }


    }

    static int bfs(int j) {
        visited[j] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(j);
        int cnt = 1;
        int cnt1 = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int k = 0; k < size; k++) {
                int poll = queue.poll();
                for (int i = 0; i < n + 1; i++) {
                    if (arr[poll][i] == 1 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                        if (i == twoPeople[1]) {
                            cnt1 = 1;
                            break;
                        }
                    }
                }

            }
            if (cnt1 != 0) {
                break;
            }

        }
        if (!visited[twoPeople[1]]) {
            return -1;
        } else {
            return cnt;
        }
    }
}
