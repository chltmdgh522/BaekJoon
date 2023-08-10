package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


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
        System.out.println(i+ " ");
        for(int j=1; j<=n; j++){
            System.out.println("start"+i);
            if(connectN[i][j]==1&&!checked[j]){
                dfs(j);
            }
        }
    }
    private static void bfs() {
        Queue<Integer> queue=new LinkedList<>();
        checked[start]=true;
        queue.offer(start);
        System.out.println(start+ " ");
        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int i=1; i<=n; i++){
                if(connectN[temp][i]==1&&!checked[i]){
                    checked[i]=true;
                    queue.offer(i);
                    System.out.println(i+ " ");
                }
            }

        }
    }

}
