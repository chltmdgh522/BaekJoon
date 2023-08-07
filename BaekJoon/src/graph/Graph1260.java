package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph1260 {
    static int n ;
    static int m;
    static int start;
    static int [][]connectN;
    static boolean [] checked;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();
        m=sc.nextInt();
        start=sc.nextInt();
        connectN=new int[n+1][n+1];
        checked=new boolean[n+1];
        for(int i=0; i<m; i++) {
            int x=sc.nextInt();
            int y=sc.nextInt();

            connectN[x][y]=connectN[y][x]=1;
        }

        dfs(start);

        checked=new boolean[n+1];
        System.out.println();
        bfs();
    }

    public static void dfs(int i){
        checked[i]=true;
        System.out.print(i+ " ");
        for(int j=1; j<=n; j++){
            if(connectN[i][j]==1&&!checked[j]){
                dfs(j);
            }
        }
    }
    private static void bfs() {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(start);
        checked[start]=true;
        System.out.print(start+ " ");
        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int j=1; j<=n; j++){
                if(connectN[temp][j]==1&&!checked[j]){
                    queue.offer(j);
                    checked[j]=true;
                    System.out.print(j+ " ");
                }
            }
        }
    }

}
