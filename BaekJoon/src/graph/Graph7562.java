package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph7562 {
    static int n;
    static int currentX;
    static int currentY;
    static int dreamX;
    static int dreamY;
    static boolean[][] vistited;
    static int cnt;
    static int dx[] = {1, 2, -1, -2, 1, 2, -1, -2};
    static int dy[] = {2, 1, 2, 1, -2, -1, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test;
        StringTokenizer st;
        test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            currentX = Integer.parseInt(st.nextToken());
            currentY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            dreamX = Integer.parseInt(st.nextToken());
            dreamY = Integer.parseInt(st.nextToken());
            vistited = new boolean[n][n];
            if (currentX == dreamX && currentY == dreamY) {
                System.out.println(0);
            } else {
                System.out.println(bfs(currentX, currentY));
            }
            cnt = 0;

        }
    }

    static int bfs(int currentX, int currentY) {
        int end = 0;
        Queue<int[]> queue = new LinkedList<>();
        vistited[currentX][currentY] = true;
        queue.add(new int[]{currentX, currentY});
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int staticX = poll[0];
                int staticY = poll[1];
                for (int i = 0; i < 8; i++) {
                    int nextStaticX = staticX + dx[i];
                    int nextStaticY = staticY + dy[i];
                    if (nextStaticX >= 0 && nextStaticX < n && nextStaticY >= 0 && nextStaticY < n) {
                        if (!vistited[nextStaticX][nextStaticY]) {
                            vistited[nextStaticX][nextStaticY] = true;
                            queue.add(new int[]{nextStaticX, nextStaticY});
                            if (nextStaticX == dreamX && nextStaticY == dreamY) {
                                end++;
                                break;
                            }
                        }
                    }
                }
            }
            if (end != 0) {
                break;
            }
        }
        return cnt;
    }
}
