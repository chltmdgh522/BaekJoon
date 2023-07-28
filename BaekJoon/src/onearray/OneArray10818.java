package onearray;

import java.util.Arrays;
import java.util.Scanner;

public class OneArray10818 {
    public static void main(String[] args) {

        Scanner sc;
        sc = new Scanner(System.in);
        int num1=sc.nextInt();
        int[] a=new int[num1];

        for(int i=0; i<a.length; i++){
            int num2=sc.nextInt();
            a[i]=num2;
        }
        Arrays.sort(a);

        System.out.println(a[0]+" "+a[a.length-1]);

    }
}
