package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back15989 {
    static int n;

    static int m;

    static int[][] street;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> rank;
    static boolean [][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        street = new int[n][n];
        rank=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                street[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(street[i][j]==2){
                    visit=new boolean[n][n];
                    bfs(i,j);
                }
            }
        }

    }

    public static int bfs(int x, int y) {
        Queue<int []> queue=new LinkedList<>();
        queue.add(new int[]{x,y});


    }
}
