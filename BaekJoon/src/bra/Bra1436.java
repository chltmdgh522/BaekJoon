package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bra1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        System.out.println(find(n));
    }
    public static int find(int n){
        int cnt=0;
        int six=666;

        while(cnt!=n){
            int six_1=six++;
            if(String.valueOf(six_1).contains("666")){
                cnt++;
            }
        }
        return six-1;
    }
}