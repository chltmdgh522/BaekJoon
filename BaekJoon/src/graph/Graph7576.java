package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph7576 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int minusCnt = 0;
        int cnt1 = 0;

        Map<Integer, Integer> hashMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];
        int cnt = 0;


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    cnt1++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    visited[i][j] = true;
                    hashMap.put(i, j);
                }
            }
        }
        bfs(hashMap);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
                if (arr[i][j] == -1) {
                    minusCnt++;
                }
            }
        }
        int total1 = 0;

        total1 = n * m - minusCnt;
        if (cnt != 0) {
            System.out.println(-1);
        } else if (total1 == cnt1) {
            System.out.println(0);
        } else {
            System.out.println(count - 1);
        }
    }


    static void bfs(Map<Integer, Integer> hashMap) {
        Queue<int[]> queue = new LinkedList<>();

        for (Integer key : hashMap.keySet()) {
            queue.add(new int[]{key, hashMap.get(key)});
        }
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int a = 0; a < size; a++) {
                int[] poll = queue.poll();
                int staticX = poll[0];
                int staticY = poll[1];

                for (int k = 0; k < 4; k++) {
                    int nextStaticX = staticX + dx[k];
                    int nextStaticY = staticY + dy[k];

                    if (nextStaticX >= 0 && nextStaticX < m && nextStaticY >= 0 && nextStaticY < n) {
                        if (!visited[nextStaticX][nextStaticY]) {
                            visited[nextStaticX][nextStaticY] = true;
                            if (arr[nextStaticX][nextStaticY] == 0) {
                                arr[nextStaticX][nextStaticY] = 1;
                                queue.add(new int[]{nextStaticX, nextStaticY});
                            } else if (arr[nextStaticX][nextStaticY] == 1) {
                                queue.add(new int[]{nextStaticX, nextStaticY});
                            }
                        }
                    }
                }
            }
            count++;
        }
    }
}
