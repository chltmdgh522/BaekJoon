package graph;

import java.util.*;

public class Graph2667 {

    static int n;

    static boolean [][] visited;

    static int [][] arr;

    static int []dx={-1,1,0,0};

    static int []dy={0,0,-1,1};
    public static void main(String[] args) {
        int count =0;
        List<Integer> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();

        arr=new int[n][n];
        visited=new boolean[n][n];

        for(int i=0; i<n; i++){
            String input=sc.next();
            for(int j=0; j<n; j++ ){
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1&&!visited[i][j]){
                    visited[i][j]=true;
                    list.add(bfs(i,j));
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for(int n : list){
            System.out.println(n);
        }
    }
    static int bfs(int i,int j){
        int cnt=1;
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{i,j});

        while(!queue.isEmpty()){
            int []temp=queue.poll();
            int nx=temp[0];
            int ny=temp[1];
            for(int k=0; k<4; k++ ){
                int nextDx=nx+dx[k];
                int nextDy=ny+dy[k];
                if(nextDx>=0&&nextDy>=0&&nextDx<n&&nextDy<n){
                    if(arr[nextDx][nextDy]==1&&!visited[nextDx][nextDy]){
                        queue.add(new int[]{nextDx,nextDy});
                        visited[nextDx][nextDy]=true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
