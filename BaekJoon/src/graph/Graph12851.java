package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph12851 {

    static int n;
    static int k;
    static int[] dx = {1, -1, 0};

    static boolean[] visit = new boolean[100001];
    static int min = Integer.MAX_VALUE;

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit[n] = true;
        bfs();
        System.out.println(min);
        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int time = 0;
        while (!queue.isEmpty() && time <= min) {
            if (n == k) {
                min = 0;
                cnt = 1;
                return;
            }
            Set<Integer> set = new LinkedHashSet<>();
            int len = queue.size();
            time++;
            for (int j = 0; j < len; j++) {
                int pos = queue.poll();

                for (int i = 0; i < 3; i++) {
                    if (i == 2) {
                        dx[2] = pos;
                    }
                    if (pos + dx[i] >= 0 && pos + dx[i] <= 100000 && !visit[pos + dx[i]]) {
                        queue.add(pos + dx[i]);
                        set.add(pos + dx[i]);
                    }
                    if (pos + dx[i] == k) {
                        if (cnt == 0) {
                            min = time;
                        }
                        if (min == time) {
                            cnt++;
                        }
                    }
                }
            }
            for (Integer i : set) {
                visit[i] = true;
            }

        }
    }
}
