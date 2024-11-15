package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SW2819 {


    static int[][] map;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static boolean[][] visit;


    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i < t + 1; i++) {
            map = new int[4][4];
            visit = new boolean[4][4];
            set=new HashSet<>();

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int x=0; x<4; x++){
                for(int y=0; y<4; y++){
                    solution(x,y,String.valueOf(map[x][y]),0);
                }
            }
            System.out.println("#" + i + " " + set.size());
        }
    }

    static void solution(int x, int y, String num, int depth) {

        if(depth==6){
            set.add(num);
            return;
        }

        for(int i=0; i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx>=0 && nx<4 && ny>=0 && ny<4){
                String text=String.valueOf(num)+String.valueOf(map[nx][ny]);
                solution(nx,ny,text,depth+1);
            }
        }

    }
}
