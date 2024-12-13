package greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Greedy2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int left=0;
        int right=-1;
        int []num=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i]=Integer.parseInt(st.nextToken());
            right=Math.max(right,num[i]);
        }
        int m=Integer.parseInt(br.readLine());
        while(left<=right){
            int mid=(left+right)/2;
            long budget=0;

            for(int i=0; i<num.length; i++){
                if(num[i]>mid){
                    budget+=mid;
                }else{
                    budget+=num[i];
                }
            }

            if(budget <=m){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        System.out.println(right);

    }
}
