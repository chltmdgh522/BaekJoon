package onearray;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class OneArray2562 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int []a=new int[9];
        int []b=new int[9];
        for(int i=0; i<a.length; i++){
            int num = sc.nextInt();
            a[i]=num;
            b[i]=num;
        }
        Arrays.sort(a);
        int cnt=1;
        for(int i=0; i<a.length; i++){

            if(a[a.length-1]==b[i]){
                break;
            }
            else{
                cnt++;
            }
        }
        System.out.println(a[a.length-1]);
        System.out.println(cnt);
    }
}
