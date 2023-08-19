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
        BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());


        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String input=stk.nextToken();
            for(int j=0; j<m; j++){
                arr[i][j]=input.charAt(j)-'0';
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
           int nx=temp[0];
           int ny=temp[1];

           for(int i=0; i<4; i++){
               int nextDx= nx+dx[i];
               int nextDy=ny+dy[i];
               if(nextDx>=0&&nextDy>=0&&nextDy<m&&nextDx<n){
                   if(!visited[nextDx][nextDy]&&arr[nextDx][nextDy]==1){
                       queue.add(new int[]{nextDx,nextDy});
                       visited[nextDx][nextDy]=true;
                       arr[nextDx][nextDy]=arr[nx][ny]+1;
                   }
               }
           }
       }
    }
}