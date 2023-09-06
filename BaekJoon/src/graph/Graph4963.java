package graph;

import java.util.*;

public class Graph4963 {

    static int n;

    static int m;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        int count=0;
        int fcnt=0;
        n = 1;
        m = 1;
        while (n != 0 && m != 0) {
            count=0;
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextInt();

            arr = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(arr[i][j]==1&&!visited[i][j]){
                        visited[i][j]=true;
                        fcnt +=bfs(i, j);
                        count++;
                    }
                }
            }

            if(n!=0&&m!=0) {
                list.add(fcnt);

            }
        }
        for (int c : list) {
            System.out.println(c);
        }

    }

    public static int bfs(int i, int j){
        int cnt=0;
        cnt++;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int staticX=poll[0];
            int staticY=poll[1];

            for(int k=0; k<8; k++){
                int nextStaticX=staticX+dx[k];
                int nextStaticY=staticY+dy[k];
                if(nextStaticX>=0&&nextStaticX<n&&nextStaticY>=0&&nextStaticY<m){
                    if(arr[nextStaticX][nextStaticY]==1&&!visited[nextStaticX][nextStaticY]){
                        visited[nextStaticX][nextStaticY]=true;
                        queue.add(new int[]{nextStaticX,nextStaticY});

                    }
                }
            }
        }

        return cnt;
    }
}
