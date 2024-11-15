import java.io.*;
import java.util.*;

public class Main {
    static class State {
        int rx, ry, bx, by, depth;
        public State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.depth > 10) return -1;
            if (board[cur.rx][cur.ry] == 'O' && board[cur.bx][cur.by] != 'O') {
                return cur.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nextRx = cur.rx;
                int nextRy = cur.ry;
                int nextBx = cur.bx;
                int nextBy = cur.by;

                // Move the red ball
                while (true) {
                    if (board[nextRx][nextRy] != '#' && board[nextRx][nextRy] != 'O') {
                        nextRx += dx[i];
                        nextRy += dy[i];
                    } else {
                        if (board[nextRx][nextRy] == '#') {
                            nextRx -= dx[i];
                            nextRy -= dy[i];
                        }
                        break;
                    }
                }

                // Move the blue ball
                while (true) {
                    if (board[nextBx][nextBy] != '#' && board[nextBx][nextBy] != 'O') {
                        nextBx += dx[i];
                        nextBy += dy[i];
                    } else {
                        if (board[nextBx][nextBy] == '#') {
                            nextBx -= dx[i];
                            nextBy -= dy[i];
                        }
                        break;
                    }
                }

                // If blue ball falls into the hole, skip
                if (board[nextBx][nextBy] == 'O') continue;

                // If both balls are in the same position, move the one that moved further
                if (nextRx == nextBx && nextRy == nextBy) {
                    if (Math.abs(nextRx - cur.rx) + Math.abs(nextRy - cur.ry) >
                        Math.abs(nextBx - cur.bx) + Math.abs(nextBy - cur.by)) {
                        nextRx -= dx[i];
                        nextRy -= dy[i];
                    } else {
                        nextBx -= dx[i];
                        nextBy -= dy[i];
                    }
                }

                if (!visited[nextRx][nextRy][nextBx][nextBy]) {
                    visited[nextRx][nextRy][nextBx][nextBy] = true;
                    queue.offer(new State(nextRx, nextRy, nextBx, nextBy, cur.depth + 1));
                }
            }
        }

        return -1;
    }
}