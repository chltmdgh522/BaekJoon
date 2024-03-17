package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Implement14503 {

    static int n;

    static int m;

    static int x;

    static int y;


    static int[] dx = {-1, 0, 1, 0};

    static int[] dy = {0, 1, 0, -1};

    static int[][] arr;

    static int cnt = 0;

    static int num = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(direction, x, y);
        System.out.println(cnt);

    }

    private static void dfs(int direction, int x, int y) {
        if (arr[x][y] == 0) {
            arr[x][y] = num;
            num++;
            cnt++;

        }
        boolean flag=false;
        int original=direction;
        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;
            int nX = x + dx[direction];
            int nY = y + dy[direction];

            if (nX >= 0 && nX < n && nY >= 0 && nY < m) {
                if(arr[nX][nY]==0) {
                    dfs(direction, nX, nY);
                    flag=true;
                    break;
                }
            }
        }
       if(!flag){
           int nd=(original+2)%4;
           int nX=x+dx[nd];
           int nY=y+dy[nd];

           if(nX >= 0 && nX < n && nY >= 0 && nY < m){
               if(arr[nX][nY]!=1){
                   dfs(original,nX,nY);
               }
           }
       }


    }

}
