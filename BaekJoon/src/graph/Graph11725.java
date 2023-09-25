package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph11725 {
    static int n;
    //static int[][] arr;

    static ArrayList<Integer>[] arr;

    static boolean[] visited;


    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x, y;
        n = Integer.parseInt(br.readLine());

        arr=new ArrayList[n+1];
        visited = new boolean[n + 1];

        for(int i=1; i<=n; i++){
            arr[i]=new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        bfs();

        for (int i = 2; i < n + 1; i++) {
            System.out.println(result[i]);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        result = new int[n + 1];

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for(int i : arr[poll]){
                if(!visited[i]) {
                    result[i]=poll;
                    queue.add(i);
                    visited[i]=true;
                }
            }

        }
    }
}
