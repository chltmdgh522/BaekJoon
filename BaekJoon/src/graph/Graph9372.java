package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph9372 {

    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int country;

        int airPlane;
        int x, y;
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            country = Integer.parseInt(st.nextToken());
            airPlane = Integer.parseInt(st.nextToken());
            for (int j = 0; j < airPlane; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());


            }
            System.out.println(country - 1);
        }
    }
}

