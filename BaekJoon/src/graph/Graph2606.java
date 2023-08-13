package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph2606 {
    static int computer;
    static int network;
    static int x,y;
    static int[][] connect;
    static boolean []visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        computer = sc.nextInt();
        network=sc.nextInt();
        connect=new int[computer+1][computer+1];
        visited=new boolean[computer+1];

        for(int i=0; i<network; i++){
            x=sc.nextInt();
            y=sc.nextInt();
            connect[x][y]=connect[y][x]=1;
        }

        visited[1]=true;
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(1);
        int cnt=0;
        while(!queue.isEmpty()){
            int temp=queue.poll();

            for(int i=1; i<computer+1; i++){
                if(connect[temp][i]==1&&!visited[i]){
                    cnt++;
                    queue.offer(i);
                    visited[i]=true;
                }
            }
        }
        return cnt;
    }
}
