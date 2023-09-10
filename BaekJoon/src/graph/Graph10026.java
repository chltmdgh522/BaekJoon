package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph10026 {
    static int n;

    static char[][] arr;

    static char[][] arr1;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count = 0;
    static int count1=0;


    public static void main(String[] args) {
        char identify;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new char[n][n];
        arr1=new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j);
            }
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    switch (arr[i][j]) {
                        case 'R' -> {
                            identify = 'R';
                            bfs(i, j, identify);
                            count++;
                        }
                        case 'B' -> {
                            identify = 'B';
                            bfs(i, j, identify);
                            count++;
                        }
                        case 'G' -> {
                            identify = 'G';
                            bfs(i, j, identify);
                            count++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]=='G'){
                    arr[i][j] = 'R';
                }
            }
        }

        visited= new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    switch (arr[i][j]) {
                        case 'R' -> {
                            identify = 'R';
                            bfs(i, j, identify);
                            count1++;
                        }
                        case 'B' -> {
                            identify = 'B';
                            bfs(i, j, identify);
                            count1++;
                        }
                    }
                }
            }
        }
        System.out.println(count+" "+count1);


    }

    static void bfs(int i, int j, char id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});


        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int staticX = poll[0];
            int staticY = poll[1];
            if (staticX >= 0 && staticX < n && staticY >= 0 && staticY < n) {
                for (int k = 0; k < 4; k++) {
                    int staticNextX = staticX + dx[k];
                    int staticNextY = staticY + dy[k];
                    if (staticNextX >= 0 && staticNextX < n && staticNextY >= 0 && staticNextY < n) {
                        if (arr[staticNextX][staticNextY] == id) {
                            if (!visited[staticNextX][staticNextY]) {
                                visited[staticNextX][staticNextY] = true;
                                switch (arr[staticNextX][staticNextY]) {
                                    case 'R' -> queue.add(new int[]{staticNextX, staticNextY});
                                    case 'G' -> queue.add(new int[]{staticNextX, staticNextY});
                                    case 'B' -> queue.add(new int[]{staticNextX, staticNextY});
                                }

                            }
                        }

                    }
                }
            }
        }

    }
}
