package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph2178 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        m= sc.nextInt();

        arr=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0; i<n; i++){
            String input = sc.next();
            for(int j=0; j<m; j++){
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        visited[0][0]=true;

        bfs(0,0);
        System.out.println(arr[n-1][m-1]);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int tempX = temp[0];
            int tempY=temp[1];
            for(int i=0; i<4; i++){
                int nextDx=tempX+dx[i];
                int nextDy=tempY+dy[i];
                if(nextDx>=0&&nextDy>=0&&nextDx<n&&nextDy<m){
                    if(!visited[nextDx][nextDy]&&arr[nextDx][nextDy]==1){
                        queue.add(new int[]{nextDx,nextDy});
                        visited[nextDx][nextDy]=true;
                        arr[nextDx][nextDy]=arr[tempX][tempY]+1;
                    }
                }
            }
        }
    }
}