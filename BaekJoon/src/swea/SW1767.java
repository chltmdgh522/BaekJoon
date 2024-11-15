package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1767 {
    static int[][] arr;
    static boolean[][] visit;

    static int max_core = Integer.MIN_VALUE;
    static int core_cnt = 0;
    static int min_length = Integer.MAX_VALUE;

    static int law_length = 0;

    static int length_cnt = 0;

    static boolean result = false;
    static boolean result2 = false;
    static int n = 0;

    static int core = 0;

    static int[] dx = {-1, 0, 1, 0};

    static int[] dy = {0, 1, 0, -1};

    static List<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            core = 0;
            arr = new int[n][n];
            visit = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    if (j == 0 || k == 0) {
                        arr[j][k] = 2;
                    } else if (j == n - 1 || k == n - 1) {
                        arr[j][k] = 2;
                    } else {
                        arr[j][k] = Integer.parseInt(st.nextToken());
                        if (arr[j][k] == 1) {
                            core++;
                            visit[j][k] = true;
                            queue.add(new int[]{j, k});
                        }
                    }
                }
            }

            int answer = solution(-1);
            System.out.println(answer);
            int num=i+1;
            System.out.println("#" + num + " " + answer);
        }
    }

    static int solution(int a) {
        int answer = 0;

        for (int i = a + 1; i < queue.size(); i++) {
            int[] poll = queue.get(i);
            int x = poll[0];
            int y = poll[1];
            for (int k = 0; k < 4; k++) {
                law_length = 0;
                back(k, x, y);
                if (result) {
                    System.out.println(law_length);
                    core_cnt++;
                    result2=true;
                    result = false;
                    min_length += law_length;
                }
                solution(i);

                if (max_core < core_cnt) {
                    max_core = core_cnt;
                    if (min_length > length_cnt) {
                        min_length = length_cnt;
                    }
                }

                if(!result2) {
                    //이전 경로 false 바꾸기
                    back2(k, x, y);
                }
            }

        }

        answer = min_length;
        min_length -= law_length;
        return answer;
    }


    static int back(int k, int x, int y) {
        System.out.println(x +" " +y);
        if (x == n - 1 || y == n - 1 || x == 0 || y == 0) {
            result = true;
            return law_length;
        }
        int nextX = x + dx[k];
        int nextY = y + dy[k];
        if (arr[nextX][nextY] != 2 && !visit[nextX][nextY]) {
            law_length++;
            visit[nextX][nextY] = true;
            back(k, nextX, nextY);
            if (!result) {
                visit[nextX][nextY] = false;
            }
        }


        return 0;
    }


    static int back2(int k, int x, int y) {
        if (x == n - 1 || y == n - 1 || x == 0 || y == 0) {
            return 0;
        }
        int nextX = x + dx[k];
        int nextY = x + dy[k];
        if (arr[nextX][nextY] ==0 && visit[nextX][nextY]) {
            visit[nextX][nextY] = false;
            back(k, nextX, nextY);

        }


        return 0;
    }
}
