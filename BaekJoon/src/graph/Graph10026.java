package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph10026 {
    static int n;

    static char [][]arr;
    static boolean [][]visited;

    static int [] dx={-1,1,0,0};
    static int [] dy={0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();

        arr=new char[n][n];
        visited=new boolean[n][n];

        for(int i=0; i<n; i++){
            String input=sc.next();
            for(int j=0; j<n; j++){
                char c = input.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]&&arr[i][j]=='R')
                visited[i][j]=true;
                bfs(i,j);
            }
        }


    }

    static void bfs(int i, int j){
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int staticX=poll[0];
            int staticY=poll[1];
            if(staticX>=0&&staticX<n&&staticY>=0&&staticY<n){
                for(int k=0; k<4; k++){
                    int staticNextX=staticX+dx[k];
                    int staticNextY=staticY+dy[k];
                    if(staticNextX>=0&&staticNextX<n&&staticNextY>=0&&staticNextY<n){
                        if(arr[staticNextX][staticNextY]=='R'&&!visited[staticNextX][staticNextY]){
                            queue.add(new int[]{staticNextX,staticNextY});
                            visited[staticNextX][staticNextY]=true;
                        }
                    }
                }
            }
        }

    }
}
