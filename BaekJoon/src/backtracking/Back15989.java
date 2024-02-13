package backtracking;

import java.io.*;
import java.util.*;

public class Back15989 {
    static int n;

    static int m;

    static int[][] street;

    static boolean[][] chickenVisit;
    static int result;

    static int resultMin = Integer.MAX_VALUE;
    static List<int[]> chicken;
    static List<int[]> home = new ArrayList<>();

    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        street = new int[n][n];
        chickenVisit = new boolean[n][n];
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                street[i][j] = Integer.parseInt(st.nextToken());
                if (street[i][j] == 1) {
                    home.add(new int[]{i, j});
                }
            }
        }
        backTracking(0);
        bw.write(String.valueOf(resultMin));
        bw.flush();
        bw.close();
    }

    public static int backTracking(int depth) {
        if (depth == m) {
            result = 0;
            resultMin = Math.min(resultMin, calculation());
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (street[i][j] == 2 && !chickenVisit[i][j]) {
                    if (!chicken.isEmpty()) {
                        int[] pair = chicken.getLast();
                        x = pair[0];
                        y = pair[1];
                    }
                    if (chicken.isEmpty() || x <= i) {
                        if (y <= j || x!=i) {
                            chickenVisit[i][j] = true;
                            chicken.add(new int[]{i, j});
                            backTracking(depth + 1);
                            chicken.removeLast();
                            chickenVisit[i][j] = false;
                        }
                    }
                }
            }
        }
        return 1;
    }

    public static int calculation() {
        for (int[] home1 : home) {
            int min = Integer.MAX_VALUE;
            for (int[] chicken1 : chicken) {
                int absX = Math.abs(chicken1[0] - home1[0]);
                int absY = Math.abs(chicken1[1] - home1[1]);
                int sum = absX + absY;
                min = Math.min(min, sum);
            }
            result += min;
        }
        return result;
    }
}

