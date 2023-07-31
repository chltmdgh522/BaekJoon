package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy11399 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        int []p=new int[n];
        for(int i=0; i< p.length; i++){
            int pp=sc.nextInt();
            p[i]=pp;
        }

        Arrays.sort(p);
        int result=0;
        int finalResult=0;
        for(int i=0; i<p.length; i++){
            if(i==0){
                result=p[i];
                finalResult=p[i];
            }
            else{
                result+=p[i];
                finalResult+=result;
            }
        }
        System.out.println(finalResult);
    }
}
