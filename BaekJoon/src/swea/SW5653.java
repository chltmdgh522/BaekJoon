package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW5653 {

    private static class Node{
        int x,y, isLive, lifeTime, nowTime;

    }

    static int[][] map;

    static int[][] world;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            world=new int[35000][35000];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < m; l++) {
                    map[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            int num = i + 1;
            System.out.println("#" + num + " " + solution(k));
        }
    }

    private static int solution(int k) {
        int answer = 0;

        for(int i=0; i<k; i++){}

        return answer;
    }
}
