package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bra17484 {

    static int N;
    static int M;

    static int[][] arr;

    static int answer = 0;
    static int min = Integer.MAX_VALUE;

    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            answer = arr[0][i];
            solution(0, 0, i, 3);
        }
        System.out.println(min);
    }

    static void solution(int level, int x, int y, int d) {
        if (level == N-1) {
            min = Math.min(answer, min);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(i==d){
                continue;
            }
            if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M) {
                answer += arr[x + dx[i]][y + dy[i]];
                solution(level + 1, x + dx[i], y + dy[i], i);
                answer -= arr[x + dx[i]][y + dy[i]];
            }

        }
    }
}
