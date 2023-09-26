package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph1743 {

    static int n;
    static int m;
    static int k;
    static int [][]arr;
    static boolean [][] visited;
    static int []dx={-1,1,0,0};
    static int []dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x,y;
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        arr=new int[n][m];
        visited=new boolean[n][m];
        for(int i=0; i<k; i++){
            st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            arr[x-1][y-1]=1;
        }
        int count=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==1&&!visited[i][j]){
                    visited[i][j]=true;
                    count=Math.max(count,bfs(i,j));
                }
            }
        }
        System.out.println(count);

    }
    public static int bfs(int x, int y){
        int cnt=1;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int staticX=poll[0];
            int staticY=poll[1];
            for(int i=0; i<4; i++){
                int staticNX=staticX+dx[i];
                int staticNY=staticY+dy[i];
                if(staticNX>=0&&staticNX<n&&staticNY>=0&&staticNY<m){
                    if(arr[staticNX][staticNY]==1 && !visited[staticNX][staticNY]){
                        queue.add(new int[]{staticNX,staticNY});
                        visited[staticNX][staticNY]=true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}
