package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bra1018 {

    static int n;
    static int m;
    static boolean [][]arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new boolean[n][m];
        for(int i=0; i<n; i++){
            String str=br.readLine();
            for(int j=0; j<m; j++){
                if(str.charAt(j)=='W'){
                    arr[i][j]=true;
                }
                else{
                    arr[i][j]=false;
                }
            }
        }

        int nr=n-7;
        int mr=m-7;
        int min=64;

        for(int i=0; i<nr; i++){
            for(int j=0; j<mr; j++){
                int cnt=find(i,j);
                min=Math.min(cnt,min);
            }
        }
        System.out.println(min);
    }

    public static int find(int x, int y){
        int fn=x+8;
        int fm=y+8;
        int cnt=0;

        boolean temp=arr[x][y];
        for(int i=x; i<fn; i++){
            for(int j=y; j<fm; j++){
                if(arr[i][j]!=temp){
                    cnt++;
                }
                temp=!temp;
            }
            temp=!temp;
        }
        cnt=Math.min(cnt,64-cnt);

        return cnt;

    }
}
