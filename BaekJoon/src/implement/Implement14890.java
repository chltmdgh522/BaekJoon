package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Implement14890 {
    static int n;

    static int l;

    static int temp;

    static int [][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());

        arr=new int[n][n];

        for (int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        imp();
    }

    private static void imp(){

    }
}
