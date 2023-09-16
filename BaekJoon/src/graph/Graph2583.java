package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph2583 {
    static int m;
    static int n;

    static int []dx={-1,1,0,0};
    static int []dy={0,0,-1,1};
    static int [][]arr;
    static boolean [][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        List<Integer> list=new ArrayList<>();
        int k;
        int x,x1;
        int y,y1;
        int result=0;
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[m][n];
        visited=new boolean[m][n];
        for(int i=0; i<k; i++){
            st=new StringTokenizer(br.readLine());
            y=Integer.parseInt(st.nextToken());
            x=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            x1=Integer.parseInt(st.nextToken());
            for(int j=x; j<x1; j++){
               for(int j1=y; j1<y1; j1++){
                   arr[j][j1]=1;
                   visited[j][j1]=true;
               }
            }
        }

        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    list.add(bfs(i, j));
                    result++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(result);
        for(int i : list){
            System.out.print(i+" ");
        }
    }

    static int bfs(int i, int j){
        int width=1;
        visited[i][j]=true;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int staticX=poll[0];
            int staticY=poll[1];
            for(int k=0; k<4; k++){
                int staticNX=staticX+dx[k];
                int staticNY=staticY+dy[k];
                if(staticNX>=0&&staticNX<m&&staticNY>=0&&staticNY<n){
                    if(!visited[staticNX][staticNY]&&arr[staticNX][staticNY]==0){
                        visited[staticNX][staticNY]=true;
                        arr[staticNX][staticNY]=1;
                        queue.add(new int[]{staticNX,staticNY});
                        width++;
                    }
                }
            }
        }
        return width;
    }
}
