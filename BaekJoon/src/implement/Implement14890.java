package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Implement14890 {
    static int n;

    static int l;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }

    private static int solution() {

        int pre1=0;
        int cnt1=0;
        int answer=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j==0) {
                    pre1 = map[i][j];
                }
                if(Math.abs(pre1 -map[i][j] )==1 ){
                    cnt1++;
                    answer++;
                }

                else{
                    break;
                }

            }
            cnt1=0;

        }

        return answer;
    }
}
