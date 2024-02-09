package backtracking;

import java.io.*;
import java.util.*;

public class Back15989 {
    static int n;

    static int m;

    static int[][] street;

    static boolean[][] chickenVisit;

    static int min;

    static int result;

    static int resultMin = Integer.MAX_VALUE;
    static int cnt;
    static List<int[]> chicken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        street = new int[n][n];
        chickenVisit = new boolean[n][n];
        cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                street[i][j] = Integer.parseInt(st.nextToken());
                if (street[i][j] == 2) {
                    cnt++;
                }
            }
        }
        chicken=new ArrayList<>();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        backTracking(0);
        bw.write(String.valueOf(resultMin));
        bw.flush();
        bw.close();
    }

    public static int backTracking(int depth) {
        if (depth == m) {
            result = 0;
            resultMin = Math.min(resultMin, calculation());
            chicken=new ArrayList<>();
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (street[i][j] == 2 && !chickenVisit[i][j]) {
                    chickenVisit[i][j] = true;
                    street[i][j] = 3;
                    chicken.add(new int[]{i+1,j+1});
                    backTracking(depth + 1);
                    street[i][j] = 2;
                    if (cnt != m) {
                        chickenVisit[i][j] = false;
                    }
                }
            }
        }
        return 1;
    }

    public static int calculation() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (street[i][j] == 1) {
                    min = Integer.MAX_VALUE;
                    for(int[] chicken1 : chicken) {
                        int absX = Math.abs(chicken1[0] - (i + 1));
                        int absY = Math.abs(chicken1[1] - (j + 1));
                        int sum = absX + absY;
                        min = Math.min(min, sum);
                    }
                    result += min;
                }
            }
        }
        return result;
    }
}

